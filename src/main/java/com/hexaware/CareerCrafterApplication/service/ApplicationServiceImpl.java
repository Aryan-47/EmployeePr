package com.hexaware.CareerCrafterApplication.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.ApplicationResponseDTO;
import com.hexaware.CareerCrafterApplication.dto.EmployerNotificationDTO;
import com.hexaware.CareerCrafterApplication.dto.JobApplicationDTO;
import com.hexaware.CareerCrafterApplication.models.Application;
import com.hexaware.CareerCrafterApplication.models.Application.ApplicationStatus;
import com.hexaware.CareerCrafterApplication.models.EmployerNotification;
import com.hexaware.CareerCrafterApplication.models.JobPosting;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;
import com.hexaware.CareerCrafterApplication.models.Resume;
import com.hexaware.CareerCrafterApplication.repository.ApplicationRepository;
import com.hexaware.CareerCrafterApplication.repository.EmpNotificationRepository;
import com.hexaware.CareerCrafterApplication.repository.JobPostingRepository;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.ResumeDatabaseRepository;

@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Autowired
    private JobSeekerProfileRepository jobSeekerRepository;

    @Autowired
    private ResumeDatabaseRepository resumeRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private EmpNotificationRepository notificationRepository;

    public Application applyToJob(JobApplicationDTO dto) throws ResourceNotFoundException {
        // Validate Job Posting
        JobPosting jobPosting = jobPostingRepository.findById(dto.getJobId())
                .orElseThrow(() -> new ResourceNotFoundException("JobPosting", "jobId", dto.getJobId()));

        // Validate Job Seeker Profile
        JobSeekerProfile jobSeekerProfile = jobSeekerRepository.findById(dto.getJobSeekerId())
                .orElseThrow(() -> new ResourceNotFoundException("JobSeekerProfile", "jobSeekerId", dto.getJobSeekerId()));

        // Validate Resume
        Resume resume = resumeRepository.findById(dto.getResumeId())
                .orElseThrow(() -> new ResourceNotFoundException("Resume", "resumeId", dto.getResumeId()));

        // Create Application
        Application application = new Application();
        application.setJobPosting(jobPosting);
        application.setJobSeekerProfile(jobSeekerProfile);
        application.setResume(resume);
        application.setApplicationDate(LocalDate.now());
        application.setStatus(Application.ApplicationStatus.PENDING);

        // Save Application
        applicationRepository.save(application);
        
        EmployerNotificationDTO notificationDTO = new EmployerNotificationDTO(
                jobPosting.getEmployerProfile().getEmployerId(),  // Employer Profile ID
                "New Job Application from " + jobSeekerProfile.getFirstName() + " " + jobSeekerProfile.getLastName(),
                LocalDateTime.now(),
                "JOB_APPLICATION",
                false
            );

        EmployerNotification notification = new EmployerNotification(
                application.getJobPosting().getEmployerProfile(),
                notificationDTO.getMessage(),
                notificationDTO.getSentAt(),
                EmployerNotification.NotificationType.valueOf(notificationDTO.getType()),
                notificationDTO.isRead()
            );

            // Save the notification
            notificationRepository.save(notification);

            return application;
    }
    
    // Fetch applications by employer
    public List<ApplicationResponseDTO> getApplicationsByEmployer(Long employerId) {
        return applicationRepository.findByJobPostingEmployerProfileEmployerId(employerId)
                .stream()
                .map(application -> modelMapper.map(application, ApplicationResponseDTO.class)) // Use ModelMapper here
                .collect(Collectors.toList());
    }

    // Fetch applications by job posting
    public List<ApplicationResponseDTO> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobPostingJobId(jobId)
                .stream()
                .map(application -> modelMapper.map(application, ApplicationResponseDTO.class)) // Use ModelMapper here
                .collect(Collectors.toList());
    }

    // Update application status
    public ApplicationResponseDTO updateApplicationStatus(Long applicationId, String status) throws ResourceNotFoundException {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application", "applicationId", applicationId));

        application.setStatus(ApplicationStatus.valueOf(status.toUpperCase()));
        Application updatedApplication = applicationRepository.save(application);

        return modelMapper.map(updatedApplication, ApplicationResponseDTO.class); // Use ModelMapper here
    }
}

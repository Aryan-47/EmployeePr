package com.hexaware.CareerCrafterApplication.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobPostingRequestDTO;
import com.hexaware.CareerCrafterApplication.models.CompanyLocation;
import com.hexaware.CareerCrafterApplication.models.EmployerProfile;
import com.hexaware.CareerCrafterApplication.models.JobPosting;
import com.hexaware.CareerCrafterApplication.models.JobSeekerNotification;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;
import com.hexaware.CareerCrafterApplication.models.RecommendedJobs;
import com.hexaware.CareerCrafterApplication.repository.CompanyLocationRepository;
import com.hexaware.CareerCrafterApplication.repository.EmployerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.JobPostingRepository;
import com.hexaware.CareerCrafterApplication.repository.JobSeekNotifRepo;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.RecommendedJobsRepository;

@Service
public class JobPostingServiceImpl implements IJobPostingService {

    @Autowired
    private EmployerProfileRepository employerProfileRepository;

    @Autowired
    private CompanyLocationRepository locationRepository;

    @Autowired
    private JobPostingRepository jobPostingRepository;
    
    @Autowired
    private JobSeekerProfileRepository jobSeekerProfileRepository;
    
    @Autowired
    private RecommendedJobsRepository recommendedJobsRepository;
    
    @Autowired
    private JobSeekNotifRepo notificationRepository;
    
    

    // Create job posting
    public JobPosting createJobPosting(JobPostingRequestDTO dto) throws ResourceNotFoundException {
        // Fetch EmployerProfile by employerId
        EmployerProfile employer = employerProfileRepository.findById(dto.getEmployerId())
                .orElseThrow(() -> new ResourceNotFoundException("EmployerProfile", "employerId", dto.getEmployerId()));

        // Fetch CompanyLocation by locationId
        CompanyLocation location = locationRepository.findById(dto.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("CompanyLocation", "locationId", dto.getLocationId()));

        // Create and populate the JobPosting object
        JobPosting jobPosting = new JobPosting();
        jobPosting.setJobTitle(dto.getJobTitle());
        jobPosting.setJobDescription(dto.getJobDescription());
        jobPosting.setLocation(location);
        jobPosting.setRequiredSkills(dto.getRequiredSkills());
        jobPosting.setEmploymentType(dto.getEmploymentType());
        jobPosting.setSalaryRange(dto.getSalaryRange());
        jobPosting.setPostedDate(LocalDate.now());
        jobPosting.setApplicationDeadline(dto.getApplicationDeadline());
        jobPosting.setStatus(dto.isStatus());
        jobPosting.setEmployerProfile(employer);

        // Save the JobPosting to the database
        JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);

        // Automatically recommend the job to job seekers after posting the job
        recommendJobToJobSeekers(savedJobPosting);

        return savedJobPosting;
    }

    private void recommendJobToJobSeekers(JobPosting jobPosting) {
        // Fetch all job seekers
        List<JobSeekerProfile> jobSeekers = jobSeekerProfileRepository.findAll();

        // Loop through job seekers and recommend the job based on skill matching
        for (JobSeekerProfile jobSeeker : jobSeekers) {
            // Check if the job seeker has matching skills
            if (jobSeeker.getSkills().stream()
                    .anyMatch(skill -> jobPosting.getRequiredSkills().toLowerCase().contains(skill.getSkillName().toLowerCase()))) {

                // Create recommendation and save it
                RecommendedJobs recommendation = new RecommendedJobs(jobPosting, jobSeeker, "Skill Match: " + getMatchedSkills(jobSeeker, jobPosting));
                recommendedJobsRepository.save(recommendation);
                
                // Create a notification for the job seeker
                JobSeekerNotification notification = new JobSeekerNotification();
                notification.setJobSeeker(jobSeeker);
                notification.setMessage("A job has been recommended for you: " + jobPosting.getJobTitle());
                notification.setSentAt(LocalDateTime.now());
                notification.setType(JobSeekerNotification.NotificationType.JOB_RECOMMENDATION); // Set the notification type as RECOMMENDATION
                notification.setRead(false);

                // Save the notification
                notificationRepository.save(notification);
            }
        }
    }

    private String getMatchedSkills(JobSeekerProfile jobSeeker, JobPosting jobPosting) {
        return jobSeeker.getSkills().stream()
                .filter(skill -> jobPosting.getRequiredSkills().toLowerCase().contains(skill.getSkillName().toLowerCase()))
                .map(skill -> skill.getSkillName())
                .collect(Collectors.joining(", "));
    }
}

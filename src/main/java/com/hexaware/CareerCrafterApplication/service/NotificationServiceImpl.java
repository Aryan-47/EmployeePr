package com.hexaware.CareerCrafterApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EmployerNotificationDTO;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerNotificationDTO;
import com.hexaware.CareerCrafterApplication.models.EmployerNotification;
import com.hexaware.CareerCrafterApplication.models.JobSeekerNotification;
import com.hexaware.CareerCrafterApplication.repository.EmpNotificationRepository;
import com.hexaware.CareerCrafterApplication.repository.JobSeekNotifRepo;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    private EmpNotificationRepository empNotificationRepository;

    @Autowired
    private JobSeekNotifRepo jobSeekerNotificationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployerNotificationDTO> getNotificationsForEmployer(Long employerId) throws ResourceNotFoundException {
        // Fetch notifications for the specific employerId
        List<EmployerNotification> notifications = empNotificationRepository.findByEmployerEmployerId(employerId);

        if (notifications.isEmpty()) {
            throw new ResourceNotFoundException("Notification", "employerId", employerId);
        }

        // Map notifications to DTOs
        return notifications.stream()
                .map(notification -> modelMapper.map(notification, EmployerNotificationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<JobSeekerNotificationDTO> getNotificationsForJobSeeker(Long jobSeekerId) throws ResourceNotFoundException {
        // Fetch notifications for the specific jobSeekerId
        List<JobSeekerNotification> notifications = jobSeekerNotificationRepository.findByJobSeekerProfileId(jobSeekerId);

        if (notifications.isEmpty()) {
            throw new ResourceNotFoundException("Notification", "jobSeekerId", jobSeekerId);
        }

        // Map notifications to DTOs
        return notifications.stream()
                .map(notification -> modelMapper.map(notification, JobSeekerNotificationDTO.class))
                .collect(Collectors.toList());
    }
}

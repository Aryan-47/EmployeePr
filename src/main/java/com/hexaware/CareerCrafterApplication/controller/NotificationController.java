package com.hexaware.CareerCrafterApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EmployerNotificationDTO;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerNotificationDTO;
import com.hexaware.CareerCrafterApplication.service.NotificationServiceImpl;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationService;

    // Get notifications for a specific employer
    @GetMapping("/employer/{employerId}")
    public ResponseEntity<List<EmployerNotificationDTO>> getNotificationsForEmployer(@PathVariable Long employerId) throws ResourceNotFoundException {
        List<EmployerNotificationDTO> notifications = notificationService.getNotificationsForEmployer(employerId);
        return ResponseEntity.ok(notifications);
    }
    
    @GetMapping("/jobseeker/{jobSeekerId}")
    public ResponseEntity<List<JobSeekerNotificationDTO>> getNotificationsForJobSeeker(@PathVariable Long jobSeekerId) throws ResourceNotFoundException {
        List<JobSeekerNotificationDTO> notifications = notificationService.getNotificationsForJobSeeker(jobSeekerId);
        return ResponseEntity.ok(notifications);
    }
    
    

}

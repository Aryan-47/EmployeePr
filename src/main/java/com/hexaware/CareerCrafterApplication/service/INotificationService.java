package com.hexaware.CareerCrafterApplication.service;

import java.util.List;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EmployerNotificationDTO;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerNotificationDTO;

public interface INotificationService {
	 public List<EmployerNotificationDTO> getNotificationsForEmployer(Long employerId) throws ResourceNotFoundException;
	 public List<JobSeekerNotificationDTO> getNotificationsForJobSeeker(Long jobSeekerId) throws ResourceNotFoundException;
}

package com.hexaware.CareerCrafterApplication.service;


import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobPostingRequestDTO;
import com.hexaware.CareerCrafterApplication.models.JobPosting;

public interface IJobPostingService {
	   public JobPosting createJobPosting(JobPostingRequestDTO dto) throws ResourceNotFoundException;
}

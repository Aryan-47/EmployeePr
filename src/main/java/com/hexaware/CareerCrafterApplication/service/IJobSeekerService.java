package com.hexaware.CareerCrafterApplication.service;

import java.util.List;

import com.hexaware.CareerCrafterApplication.dto.JobPostingResponseDTO;
import com.hexaware.CareerCrafterApplication.models.JobPosting;

public interface IJobSeekerService {
	public List<JobPostingResponseDTO> getAllActiveJobs();
	public JobPostingResponseDTO convertToDTO(JobPosting jobPosting);
}

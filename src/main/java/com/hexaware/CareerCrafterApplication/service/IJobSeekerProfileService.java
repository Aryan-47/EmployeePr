package com.hexaware.CareerCrafterApplication.service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;

public interface IJobSeekerProfileService {
	public String completeProfile(JobSeekerProfileCompletionDTO profileDTO) throws ResourceNotFoundException;
    public String deleteJobSeekerByID(Long profileId) throws ResourceNotFoundException;
    public JobSeekerProfile getJobSeekerById(Long profileId) throws ResourceNotFoundException;
}

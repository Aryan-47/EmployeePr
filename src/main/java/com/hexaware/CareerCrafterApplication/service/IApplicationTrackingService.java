package com.hexaware.CareerCrafterApplication.service;

import java.util.List;

import com.hexaware.CareerCrafterApplication.dto.ApplicationTrackingDTO;
import com.hexaware.CareerCrafterApplication.models.Application;

public interface IApplicationTrackingService {
	public List<ApplicationTrackingDTO> getApplicationsByJobSeeker(Long jobSeekerId);
	public ApplicationTrackingDTO convertToTrackingDTO(Application application);
	
}

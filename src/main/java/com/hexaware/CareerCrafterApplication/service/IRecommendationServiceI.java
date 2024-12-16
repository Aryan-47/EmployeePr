package com.hexaware.CareerCrafterApplication.service;

import java.util.List;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.RecommendedJobDTO;

public interface IRecommendationServiceI {
	 public List<RecommendedJobDTO> getRecommendedJobsByJobSeekerId(Long jobSeekerId) throws ResourceNotFoundException;
	 
}

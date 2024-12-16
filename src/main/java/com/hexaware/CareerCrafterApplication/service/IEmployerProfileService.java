package com.hexaware.CareerCrafterApplication.service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EmployerProfileCompletionDTO;

public interface IEmployerProfileService  {

	public String completeProfile(EmployerProfileCompletionDTO employerProfileCompletionDTO) throws ResourceNotFoundException;

}

package com.hexaware.CareerCrafterApplication.service;

import java.util.List;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.ApplicationResponseDTO;
import com.hexaware.CareerCrafterApplication.dto.JobApplicationDTO;
import com.hexaware.CareerCrafterApplication.models.Application;

public interface IApplicationService {
    public Application applyToJob(JobApplicationDTO dto) throws ResourceNotFoundException;
    public List<ApplicationResponseDTO> getApplicationsByEmployer(Long employerId);
    public List<ApplicationResponseDTO> getApplicationsByJobId(Long jobId);
    public ApplicationResponseDTO updateApplicationStatus(Long applicationId, String status) throws ResourceNotFoundException;

}

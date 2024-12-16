package com.hexaware.CareerCrafterApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.dto.JobPostingResponseDTO;
import com.hexaware.CareerCrafterApplication.models.JobPosting;
import com.hexaware.CareerCrafterApplication.repository.JobPostingRepository;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService{
	
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private JobPostingRepository jobPostingRepository;

    public List<JobPostingResponseDTO> getAllActiveJobs() {
        List<JobPosting> jobs = jobPostingRepository.findAllActiveJobs();
        return jobs.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public JobPostingResponseDTO convertToDTO(JobPosting jobPosting) {
        // Use ModelMapper for basic mapping
        JobPostingResponseDTO dto = modelMapper.map(jobPosting, JobPostingResponseDTO.class);
        
        // Add any additional custom mappings
        dto.setEmployerEmail(jobPosting.getEmployerProfile().getEmail());
        dto.setLocation(jobPosting.getLocation().getCity() + ", " + jobPosting.getLocation().getState());
        dto.setCompanyName(jobPosting.getEmployerProfile().getCompany().getCompanyName());
        
        return dto;
    }
    
}

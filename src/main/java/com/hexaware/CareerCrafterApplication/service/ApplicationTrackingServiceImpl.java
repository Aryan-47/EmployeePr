package com.hexaware.CareerCrafterApplication.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.dto.ApplicationTrackingDTO;
import com.hexaware.CareerCrafterApplication.models.Application;
import com.hexaware.CareerCrafterApplication.repository.ApplicationTrackingRepository;

@Service
public class ApplicationTrackingServiceImpl implements IApplicationTrackingService{

    @Autowired
    private ApplicationTrackingRepository applicationTrackingRepository;

    @Autowired
    private ModelMapper modelMapper; // Inject ModelMapper

    // Fetch applications for a job seeker
    public List<ApplicationTrackingDTO> getApplicationsByJobSeeker(Long jobSeekerId) {
        return applicationTrackingRepository.findByJobSeekerProfileProfileId(jobSeekerId)
                .stream()
                .map(this::convertToTrackingDTO)
                .collect(Collectors.toList());
    }

    // Convert Application entity to DTO using ModelMapper
    public ApplicationTrackingDTO convertToTrackingDTO(Application application) {
    	ApplicationTrackingDTO dto = modelMapper.map(application, ApplicationTrackingDTO.class);
    	return dto;
    }
}

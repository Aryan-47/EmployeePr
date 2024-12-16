package com.hexaware.CareerCrafterApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobPostingResponseDTO;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;
import com.hexaware.CareerCrafterApplication.service.JobSeekerProfileServiceImpl;
import com.hexaware.CareerCrafterApplication.service.JobSeekerServiceImpl;

@RestController
@RequestMapping("/api/jobseeker/")
public class JobSeekerController {

    @Autowired
    private JobSeekerServiceImpl jobSeekerService;
    @Autowired
    private JobSeekerProfileServiceImpl jobSeekerProfileService;

    @GetMapping("/jobs")
    public ResponseEntity<List<JobPostingResponseDTO>> getAllActiveJobs() {
        List<JobPostingResponseDTO> activeJobs = jobSeekerService.getAllActiveJobs();
        return ResponseEntity.ok(activeJobs);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJobSeeker(@PathVariable("id") Long profileId) throws ResourceNotFoundException {
        String responseMessage = jobSeekerProfileService.deleteJobSeekerByID(profileId);
        return ResponseEntity.ok(responseMessage);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerProfile> getJobSeekerByID(@PathVariable("id") Long profileId) throws ResourceNotFoundException {
    	JobSeekerProfile job = jobSeekerProfileService.getJobSeekerById(profileId);
        return ResponseEntity.ok(job);
    }
    
    
    
    
}

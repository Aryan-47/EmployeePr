package com.hexaware.CareerCrafterApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.ApplicationResponseDTO;
import com.hexaware.CareerCrafterApplication.dto.JobApplicationDTO;
import com.hexaware.CareerCrafterApplication.models.Application;
import com.hexaware.CareerCrafterApplication.service.ApplicationServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/applications/")
public class ApplicationController {

    @Autowired
    private ApplicationServiceImpl applicationService;

    @PostMapping("/jobSeeker/apply")
    public ResponseEntity<String> applyToJob(@Valid @RequestBody JobApplicationDTO dto) throws ResourceNotFoundException {
            applicationService.applyToJob(dto);
            return ResponseEntity.ok("Applied to job succesfully");
    }
    
    // Get all applications by employer
    @GetMapping("/employer/{employerId}")
    public ResponseEntity<List<ApplicationResponseDTO>> getApplicationsByEmployer(@PathVariable Long employerId) {
        List<ApplicationResponseDTO> applications = applicationService.getApplicationsByEmployer(employerId);
        return ResponseEntity.ok(applications);
    }

    // Get all applications for a specific job
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponseDTO>> getApplicationsByJobId(@PathVariable Long jobId) {
        List<ApplicationResponseDTO> applications = applicationService.getApplicationsByJobId(jobId);
        return ResponseEntity.ok(applications);
    }

    // Update application status (ACCEPTED/REJECTED)
    @PutMapping("/{applicationId}/status")
    public ResponseEntity<ApplicationResponseDTO> updateApplicationStatus(
            @PathVariable Long applicationId,
            @RequestParam String status) throws ResourceNotFoundException {
        ApplicationResponseDTO updatedApplication = applicationService.updateApplicationStatus(applicationId, status);
        return ResponseEntity.ok(updatedApplication);
    }
}

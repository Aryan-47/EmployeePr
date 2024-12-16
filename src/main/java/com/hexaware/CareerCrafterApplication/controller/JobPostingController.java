package com.hexaware.CareerCrafterApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobPostingRequestDTO;
import com.hexaware.CareerCrafterApplication.models.JobPosting;
import com.hexaware.CareerCrafterApplication.service.JobPostingServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employer/")
public class JobPostingController {

    @Autowired
    private JobPostingServiceImpl jobPostingService;

    @PostMapping("/jobPosting")
    public ResponseEntity<String> createJobPosting(@Valid @RequestBody JobPostingRequestDTO jobPostingRequestDTO) throws ResourceNotFoundException {
        jobPostingService.createJobPosting(jobPostingRequestDTO);
        return ResponseEntity.ok("Job Posted Succesfully");
    }
}

package com.hexaware.CareerCrafterApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobPostingResponseDTO;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.service.JobSeekerProfileServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobseeker/")
public class JobSeekerProfileController {

    @Autowired
    private JobSeekerProfileServiceImpl jobSeekerProfileService;

    @PostMapping("/profile")
    public ResponseEntity<String> completeProfile(@Valid @RequestBody JobSeekerProfileCompletionDTO profileDTO) throws ResourceNotFoundException {
        String response = jobSeekerProfileService.completeProfile(profileDTO);
        return ResponseEntity.ok(response);
    }
}

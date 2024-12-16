package com.hexaware.CareerCrafterApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.dto.ApplicationTrackingDTO;
import com.hexaware.CareerCrafterApplication.service.ApplicationTrackingServiceImpl;

@RestController
@RequestMapping("/api/applicationTracking")
public class ApplicationTrackingController {

    @Autowired
    private ApplicationTrackingServiceImpl applicationTrackingService;

    // Get applications for a job seeker
    @GetMapping("/jobSeeker/{jobSeekerId}")
    public ResponseEntity<List<ApplicationTrackingDTO>> getApplicationsByJobSeeker(
            @PathVariable Long jobSeekerId) {
        List<ApplicationTrackingDTO> applications = applicationTrackingService.getApplicationsByJobSeeker(jobSeekerId);
        return ResponseEntity.ok(applications);
    }
}

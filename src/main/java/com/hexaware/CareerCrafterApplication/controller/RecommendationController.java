package com.hexaware.CareerCrafterApplication.controller;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.RecommendedJobDTO;
import com.hexaware.CareerCrafterApplication.service.RecommendationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recommendations/")
public class RecommendationController {

    @Autowired
    private RecommendationServiceImpl recommendationService;

    // Endpoint to get recommended jobs for a specific job seeker
    @GetMapping("/jobSeeker/{jobSeekerId}")
    public List<RecommendedJobDTO> getRecommendedJobs(@PathVariable Long jobSeekerId) throws ResourceNotFoundException {
        return recommendationService.getRecommendedJobsByJobSeekerId(jobSeekerId);
    }
}

package com.hexaware.CareerCrafterApplication.controller;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EmployerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.service.EmployerProfileServiceImpl;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employer/")
public class EmployerProfileController {

    @Autowired
    private EmployerProfileServiceImpl employerProfileService;

    @PostMapping("/profile")
    public ResponseEntity<String> completeProfile(@Valid @RequestBody EmployerProfileCompletionDTO employerProfileCompletionDTO) throws ResourceNotFoundException {
        String response = employerProfileService.completeProfile(employerProfileCompletionDTO);
        return ResponseEntity.ok(response);
    }
}

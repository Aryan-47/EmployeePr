package com.hexaware.CareerCrafterApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.dto.EmployerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.JWTAuthResponse;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.LoginDTO;
import com.hexaware.CareerCrafterApplication.service.AuthServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO loginDTO) {
    	JWTAuthResponse token = authService.login(loginDTO);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/registerJobSeeker")
    public ResponseEntity<String> registerJobSeeker(@Valid @RequestBody JobSeekerRegisterDTO userDTO) {
        String response = authService.registerJobSeeker(userDTO);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/registerEmployer")
    public ResponseEntity<String> registerEmployer(@Valid @RequestBody EmployerRegisterDTO userDTO) {
        String response = authService.registerEmployer(userDTO);
        return ResponseEntity.ok(response);
    }
    
}


package com.hexaware.CareerCrafterApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.hexaware.CareerCrafterApplication.controller.AuthController;
import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EmployerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerRegisterDTO;
import com.hexaware.CareerCrafterApplication.dto.ResumeDTO;
import com.hexaware.CareerCrafterApplication.dto.SkillDTO;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;
import com.hexaware.CareerCrafterApplication.models.Skill;
import com.hexaware.CareerCrafterApplication.repository.CompanyRepository;
import com.hexaware.CareerCrafterApplication.repository.EducationRepository;
import com.hexaware.CareerCrafterApplication.repository.ExperienceRepository;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.ResumeDatabaseRepository;
import com.hexaware.CareerCrafterApplication.repository.SkillRepository;
import com.hexaware.CareerCrafterApplication.service.JobSeekerProfileServiceImpl;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class JPAMethodsTest {

	
    @Autowired
    private AuthController authController;
    
    @Autowired
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ResumeDatabaseRepository resumeDatabaseRepository;

    @Autowired
    private JobSeekerProfileServiceImpl jobSeekerProfileService;
    
    @Autowired
    private EducationRepository educationRepository;
    
    @Autowired
    private ExperienceRepository experienceRepository;
    
    @Autowired
    private CompanyRepository companyRepository;
    

	    // 1. Job Seeker Profile Save and Fetch
	    @Test
	    void a_jobSeekerRegisterTest() {
	        // Create the DTO for job seeker registration
	        JobSeekerRegisterDTO jobSeekerRegisterDTO = new JobSeekerRegisterDTO(
	            "johnDoe123",      // Username
	            "securePassword123", // Password
	            "john.doe@email.com", // Email
	            "John",              // First Name
	            "Doe",               // Last Name
	            "1234567890"         // Phone Number
	        );

	        // Call the controller methodfor registration
	        ResponseEntity<String> response = authController.registerJobSeeker(jobSeekerRegisterDTO);

	        // Assert that the registration is successful
	        assertEquals(200, response.getStatusCodeValue());
	        assertEquals("Job Seeker registered successfully", response.getBody());
	    }
	    
	    // 2. Employer Registration Test
	    @Test
	    void b_empRegTest() {
	        // Create the DTO for employer registration
	        EmployerRegisterDTO employerRegisterDTO = new EmployerRegisterDTO("techcorp", "securePassword123", "techcorp@example.com");

	        // Call the controller method for registration
	        ResponseEntity<String> response = authController.registerEmployer(employerRegisterDTO);

	        // Assert the registration is successful
	        assertEquals(200, response.getStatusCodeValue());
	        assertEquals("Employer registered successfully", response.getBody());

	    }

	    

	   
	    

	 

}
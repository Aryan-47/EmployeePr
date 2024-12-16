package com.hexaware.CareerCrafterApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.CompanyDTO;
import com.hexaware.CareerCrafterApplication.dto.EmployerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.dto.LocationDTO;
import com.hexaware.CareerCrafterApplication.models.Company;
import com.hexaware.CareerCrafterApplication.models.EmployerProfile;
import com.hexaware.CareerCrafterApplication.repository.CompanyRepository;
import com.hexaware.CareerCrafterApplication.repository.EmployerProfileRepository;
import com.hexaware.CareerCrafterApplication.service.EmployerProfileServiceImpl;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class EmployerProfileServiceImplTest {

    @InjectMocks
    private EmployerProfileServiceImpl employerProfileService;

    @Mock
    private EmployerProfileRepository employerProfileRepository;

    @Mock
    private CompanyRepository companyRepository;

    private EmployerProfileCompletionDTO employerProfileCompletionDTO;
    private EmployerProfile employerProfile;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup CompanyLocationDTO for test
        LocationDTO companyLocationDTO = new LocationDTO("New York", "NY", "USA");

        // Setup EmployerProfileCompletionDTO for test with CompanyDTO and CompanyLocationDTO
        employerProfileCompletionDTO = new EmployerProfileCompletionDTO();
        employerProfileCompletionDTO.setEmployerId(1L);

        employerProfileCompletionDTO.setCompany(new CompanyDTO("TechCorp",companyLocationDTO, "IT", "www.techcorp.com"));

        // Setup EmployerProfile for test
        employerProfile = new EmployerProfile();
        employerProfile.setEmployerId(1L);
        employerProfile.setUsername("techuser");
        employerProfile.setEmail("techuser@example.com");
    }

    @Test
    void a_completeProfile_shouldCompleteProfileSuccessfully() throws ResourceNotFoundException {
        // Mock behavior
        when(employerProfileRepository.findByEmployerId(1L)).thenReturn(employerProfile);
        when(companyRepository.save(any(Company.class))).thenReturn(new Company());

        // Call service method
        String result = employerProfileService.completeProfile(employerProfileCompletionDTO);

        // Assert the expected result
        assertEquals("Employer Profile completed successfully", result);
        verify(employerProfileRepository, times(1)).save(employerProfile);
        verify(companyRepository, times(1)).save(any(Company.class));
    }
}

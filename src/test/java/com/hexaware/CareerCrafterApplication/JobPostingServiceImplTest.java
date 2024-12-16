package com.hexaware.CareerCrafterApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobPostingRequestDTO;
import com.hexaware.CareerCrafterApplication.models.CompanyLocation;
import com.hexaware.CareerCrafterApplication.models.EmployerProfile;
import com.hexaware.CareerCrafterApplication.models.JobPosting;
import com.hexaware.CareerCrafterApplication.models.JobSeekerNotification;
import com.hexaware.CareerCrafterApplication.models.RecommendedJobs;
import com.hexaware.CareerCrafterApplication.repository.CompanyLocationRepository;
import com.hexaware.CareerCrafterApplication.repository.EmployerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.JobPostingRepository;
import com.hexaware.CareerCrafterApplication.repository.JobSeekNotifRepo;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.RecommendedJobsRepository;
import com.hexaware.CareerCrafterApplication.service.JobPostingServiceImpl;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class JobPostingServiceImplTest {

    @InjectMocks
    private JobPostingServiceImpl jobPostingService;

    @Mock
    private EmployerProfileRepository employerProfileRepository;

    @Mock
    private CompanyLocationRepository locationRepository;

    @Mock
    private JobPostingRepository jobPostingRepository;

    @Mock
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    @Mock
    private RecommendedJobsRepository recommendedJobsRepository;

    @Mock
    private JobSeekNotifRepo notificationRepository;

    private EmployerProfile mockEmployer;
    private CompanyLocation mockLocation;
    private JobPostingRequestDTO mockJobPostingDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock EmployerProfile
        mockEmployer = new EmployerProfile();
        mockEmployer.setEmployerId(1L);

        // Mock CompanyLocation
        mockLocation = new CompanyLocation();
        mockLocation.setLocationId(1L);

        // Mock JobPostingRequestDTO
        mockJobPostingDTO = new JobPostingRequestDTO();
        mockJobPostingDTO.setEmployerId(1L);
        mockJobPostingDTO.setLocationId(1L);
        mockJobPostingDTO.setJobTitle("Software Engineer");
        mockJobPostingDTO.setJobDescription("Develop and maintain software solutions.");
        mockJobPostingDTO.setRequiredSkills("Java, Spring Boot");
        mockJobPostingDTO.setEmploymentType("Full-time");
        mockJobPostingDTO.setSalaryRange("50000-70000");
        mockJobPostingDTO.setApplicationDeadline(LocalDate.now().plusDays(10));
        mockJobPostingDTO.setStatus(true);
    }

    @Test
    void a_testCreateJobPosting() throws ResourceNotFoundException {
        // Arrange
        when(employerProfileRepository.findById(1L)).thenReturn(Optional.of(mockEmployer));
        when(locationRepository.findById(1L)).thenReturn(Optional.of(mockLocation));

        JobPosting savedJobPosting = new JobPosting();
        savedJobPosting.setJobId(1L);
        savedJobPosting.setJobTitle("Software Engineer");

        when(jobPostingRepository.save(any(JobPosting.class))).thenReturn(savedJobPosting);

        // Act
        JobPosting result = jobPostingService.createJobPosting(mockJobPostingDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Software Engineer", result.getJobTitle());

    }

    @Test
    void b_testCreateJobPostingThrowsResourceNotFoundException() {
        // Arrange: Employer not found
        when(employerProfileRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException exception = 
            org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
                jobPostingService.createJobPosting(mockJobPostingDTO);
            });

        assertEquals("EmployerProfile not found with employerId : 1", exception.getMessage());

        // Verify no further interactions
        verify(locationRepository, never()).findById(anyLong());
        verify(jobPostingRepository, never()).save(any(JobPosting.class));
    }
}

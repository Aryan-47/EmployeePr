package com.hexaware.CareerCrafterApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EducationDTO;
import com.hexaware.CareerCrafterApplication.dto.ExperienceDTO;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.dto.ResumeDTO;
import com.hexaware.CareerCrafterApplication.dto.SkillDTO;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;
import com.hexaware.CareerCrafterApplication.models.Resume;
import com.hexaware.CareerCrafterApplication.models.Skill;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.ResumeDatabaseRepository;
import com.hexaware.CareerCrafterApplication.repository.SkillRepository;
import com.hexaware.CareerCrafterApplication.service.JobSeekerProfileServiceImpl;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class JobSeekerProfileServiceImplTest {

    @Mock
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    @Mock
    private SkillRepository skillRepository;

    @Mock
    private ResumeDatabaseRepository resumeDatabaseRepository;

    @InjectMocks
    private JobSeekerProfileServiceImpl jobSeekerProfileService;

    @Test
    void a_completeProfile_successful() throws ResourceNotFoundException {
        // Prepare data
        JobSeekerProfile profile = new JobSeekerProfile();
        profile.setProfileId(1L);
        profile.setFirstName("John");
        profile.setLastName("Doe");

        JobSeekerProfileCompletionDTO profileDTO = new JobSeekerProfileCompletionDTO();
        profileDTO.setProfileId(1L);
        profileDTO.setSkills(List.of(new SkillDTO("Java")));
        profileDTO.setEducationList(List.of(new EducationDTO("BSc", "University", "A", "2023")));
        profileDTO.setExperienceList(List.of(new ExperienceDTO("Developer", "XYZ Corp", 2.5, "Developed software")));
        profileDTO.setResume(new ResumeDTO("resume.pdf", "http://resume.url"));

        // Mock repository responses
        when(jobSeekerProfileRepository.findByProfileId(1L)).thenReturn(profile);
        when(skillRepository.save(any(Skill.class))).thenReturn(new Skill());
        when(resumeDatabaseRepository.save(any(Resume.class))).thenReturn(new Resume());

        // Call service method
        String result = jobSeekerProfileService.completeProfile(profileDTO);

        // Verify interactions and assertions
        assertEquals("Job Seeker Profile completed successfully", result);
        assertEquals(1, profile.getSkills().size()); // Ensure skills were added to the profile
        assertEquals(1, profile.getEducationList().size()); // Ensure education was added
        assertEquals(1, profile.getExperienceList().size()); // Ensure experience was added
        assertEquals(1, profile.getResumes().size()); // Ensure resume was added
        verify(jobSeekerProfileRepository, times(1)).save(profile); // Ensure save was called
    }

    @Test
    void b_completeProfile_profileNotFound() {
        // Prepare data
        JobSeekerProfileCompletionDTO profileDTO = new JobSeekerProfileCompletionDTO();
        profileDTO.setProfileId(1L);

        // Mock repository responses
        when(jobSeekerProfileRepository.findByProfileId(1L)).thenReturn(null);

        // Call service method and assert exception
        assertThrows(ResourceNotFoundException.class, () -> {
            jobSeekerProfileService.completeProfile(profileDTO);
        });
    }
}

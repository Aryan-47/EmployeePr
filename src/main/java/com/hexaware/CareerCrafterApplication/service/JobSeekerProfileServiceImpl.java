package com.hexaware.CareerCrafterApplication.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.JobSeekerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.dto.ResumeDTO;
import com.hexaware.CareerCrafterApplication.models.Education;
import com.hexaware.CareerCrafterApplication.models.Experience;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;
import com.hexaware.CareerCrafterApplication.models.Resume;
import com.hexaware.CareerCrafterApplication.models.Skill;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.ResumeDatabaseRepository;
import com.hexaware.CareerCrafterApplication.repository.SkillRepository;

@Service
public class JobSeekerProfileServiceImpl implements IJobSeekerProfileService {

    @Autowired
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ResumeDatabaseRepository resumeDatabaseRepository;

    @Override
    public String completeProfile(JobSeekerProfileCompletionDTO profileDTO) throws ResourceNotFoundException {
        // Fetch JobSeekerProfile by profileId
        JobSeekerProfile profile = jobSeekerProfileRepository.findByProfileId(profileDTO.getProfileId());
        if (profile == null) {
            throw new ResourceNotFoundException("JobSeekerProfile", "profileId", profileDTO.getProfileId());
        }

        // Add Skills
        if (profileDTO.getSkills() != null) {
            profile.setSkills(profileDTO.getSkills().stream()
                    .map(skillDTO -> new Skill(skillDTO.getSkillName(), profile))
                    .collect(Collectors.toList()));
        }

        // Add Education
        if (profileDTO.getEducationList() != null) {
            profile.setEducationList(profileDTO.getEducationList().stream()
                    .map(eduDTO -> new Education(eduDTO.getDegree(), eduDTO.getInstitution(), eduDTO.getGrade(),
                            eduDTO.getYearOfPassing(), profile))
                    .collect(Collectors.toList()));
        }

        // Add Experience
        if (profileDTO.getExperienceList() != null) {
            profile.setExperienceList(profileDTO.getExperienceList().stream()
                    .map(expDTO -> new Experience(expDTO.getJobTitle(), expDTO.getCompanyName(),
                            expDTO.getDuration(), expDTO.getResponsibilities(), profile))
                    .collect(Collectors.toList()));
        }

        // Add Resume
        if (profileDTO.getResume() != null) {
            ResumeDTO resumeDTO = profileDTO.getResume();
            Resume resume = new Resume();
            resume.setResumeFileName(resumeDTO.getResumeFileName());
            resume.setResumeURL(resumeDTO.getResumeURL());
            resume.setJobSeekerProfile(profile);
            
            // Add the resume to the profile's resume list
            profile.getResumes().add(resume);
            resumeDatabaseRepository.save(resume);
        }

        // Save the updated profile
        jobSeekerProfileRepository.save(profile);

        return "Job Seeker Profile completed successfully";
    }
    
    public String deleteJobSeekerByID(Long profileId) throws ResourceNotFoundException {
        JobSeekerProfile profile = jobSeekerProfileRepository.findByProfileId(profileId);
        if (profile == null) {
            throw new ResourceNotFoundException("JobSeekerProfile", "profileId", profileId);
        }

        jobSeekerProfileRepository.delete(profile);
        return "Job Seeker Profile deleted successfully!";
    }
    
    @Override
    public JobSeekerProfile getJobSeekerById(Long profileId) throws ResourceNotFoundException {
    	 JobSeekerProfile profile = jobSeekerProfileRepository.findByProfileId(profileId);
         if (profile == null) {
             throw new ResourceNotFoundException("JobSeekerProfile", "profileId", profileId);
         }
         return profile;
    }

}

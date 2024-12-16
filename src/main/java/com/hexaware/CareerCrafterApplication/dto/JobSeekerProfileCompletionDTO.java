package com.hexaware.CareerCrafterApplication.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class JobSeekerProfileCompletionDTO {

	@NotNull(message = "Profile ID cannot be null")
	private Long profileId; // ID of the registered job seeker
											
	@NotNull(message = "Skills list cannot be null")
	@Valid
	private List<SkillDTO> skills; // List of skills
														
	@NotNull(message = "Education list cannot be null")
	@Valid
	private List<EducationDTO> educationList; // List of education details
														
	@NotNull(message = "Experience list cannot be null")
	@Valid
	private List<ExperienceDTO> experienceList; // List of experience details
														
	@NotNull(message = "Resume cannot be null")
	@Valid
	private ResumeDTO resume; // Resume details

    public JobSeekerProfileCompletionDTO() {
    }

    public JobSeekerProfileCompletionDTO(Long profileId, List<SkillDTO> skills, List<EducationDTO> educationList,
                                         List<ExperienceDTO> experienceList, ResumeDTO resume) {
        this.profileId = profileId;
        this.skills = skills;
        this.educationList = educationList;
        this.experienceList = experienceList;
        this.resume = resume;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long userId) {
        this.profileId = userId;
    }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }

    public List<EducationDTO> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<EducationDTO> educationList) {
        this.educationList = educationList;
    }

    public List<ExperienceDTO> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<ExperienceDTO> experienceList) {
        this.experienceList = experienceList;
    }

    public ResumeDTO getResume() {
        return resume;
    }

    public void setResume(ResumeDTO resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "JobSeekerProfileCompletionDTO{" +
                "userId=" + profileId +
                ", skills=" + skills +
                ", educationList=" + educationList +
                ", experienceList=" + experienceList +
                ", resume=" + resume +
                '}';
    }
}

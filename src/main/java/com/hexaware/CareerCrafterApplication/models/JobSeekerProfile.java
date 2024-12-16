package com.hexaware.CareerCrafterApplication.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class JobSeekerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
    private String username;
    private String firstName;
    private String email;
    private String lastName;
    private String phoneNumber;
    
    @OneToMany(mappedBy = "jobSeekerProfile", cascade = CascadeType.ALL)
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "jobSeekerProfile", cascade = CascadeType.ALL)
    private List<Education> educationList = new ArrayList<>();

    @OneToMany(mappedBy = "jobSeekerProfile", cascade = CascadeType.ALL)
    private List<Experience> experienceList = new ArrayList<>();

    @OneToMany(mappedBy = "jobSeekerProfile", cascade = CascadeType.ALL)
    private List<Resume> resumes = new ArrayList<>();


	public JobSeekerProfile() {
		super();
	}
	

	public JobSeekerProfile(Long profileId, String username, String firstName, String email, String lastName,
			String phoneNumber, List<Skill> skills, List<Education> educationList, List<Experience> experienceList,
			List<Resume> resumes) {
		super();
		this.profileId = profileId;
		this.username = username;
		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.skills = skills;
		this.educationList = educationList;
		this.experienceList = experienceList;
		this.resumes = resumes;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Long getProfileId() {
		return profileId;
	}


	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Education> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Experience> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<Experience> experienceList) {
		this.experienceList = experienceList;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}


	@Override
	public String toString() {
		return "JobSeekerProfile [profileId=" + profileId + ", username=" + username + ", firstName=" + firstName
				+ ", email=" + email + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", skills=" + skills
				+ ", educationList=" + educationList + ", experienceList=" + experienceList + ", resumes=" + resumes
				+ "]";
	}


	
	
	


    // Getters, Setters, Constructors
    
    
    
    
}

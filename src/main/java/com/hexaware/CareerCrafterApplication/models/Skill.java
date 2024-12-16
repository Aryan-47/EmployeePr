package com.hexaware.CareerCrafterApplication.models;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    @ManyToOne
    @JoinColumn(name = "job_seeker_profile_id", nullable = false)
    private JobSeekerProfile jobSeekerProfile;

    public Skill() {
    }
    
    

    public Skill(Long id, String skillName, JobSeekerProfile jobSeekerProfile) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.jobSeekerProfile = jobSeekerProfile;
	}
    
    



	public Skill(Long id, String skillName) {
		super();
		this.id = id;
		this.skillName = skillName;
	}



	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}



	public Skill(String skillName, JobSeekerProfile jobSeekerProfile) {
        this.skillName = skillName;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                ", jobSeekerProfile=" + jobSeekerProfile.getProfileId() +
                '}';
    }
}

package com.hexaware.CareerCrafterApplication.models;

import jakarta.persistence.*;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;
    private String companyName;
    private Double duration; // Duration in years or months (e.g., 1.5 for 1.5 years)
    private String responsibilities;

    @ManyToOne
    @JoinColumn(name = "job_seeker_profile_id", nullable = false)
    private JobSeekerProfile jobSeekerProfile;

    public Experience() {
    }
    
    

    public Experience(Long id, String jobTitle, String companyName, Double duration, String responsibilities,
			JobSeekerProfile jobSeekerProfile) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.duration = duration;
		this.responsibilities = responsibilities;
		this.jobSeekerProfile = jobSeekerProfile;
	}
    



	public Experience(Long id, String jobTitle, String companyName, Double duration, String responsibilities) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.duration = duration;
		this.responsibilities = responsibilities;
	}



	public Experience(String jobTitle, String companyName, Double duration, String responsibilities) {
		super();
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.duration = duration;
		this.responsibilities = responsibilities;
	}



	public Experience(String jobTitle, String companyName, Double duration, String responsibilities, JobSeekerProfile jobSeekerProfile) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.duration = duration;
        this.responsibilities = responsibilities;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", duration=" + duration +
                ", responsibilities='" + responsibilities + '\'' +
                ", jobSeekerProfile=" + (jobSeekerProfile != null ? jobSeekerProfile.getProfileId() : null) +
                '}';
    }
}

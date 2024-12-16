package com.hexaware.CareerCrafterApplication.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Application {
	public enum ApplicationStatus{
		PENDING, REVIEWED, ACCEPTED, REJECTED
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPosting jobPosting;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeekerProfile jobSeekerProfile;

    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status; // Enum for Pending, Reviewed, Accepted, Rejected

    @ManyToOne
    @JoinColumn(name = "resume_id") // Reference to ResumeDatabase entity
    private Resume resume;  // Use ResumeDatabase entity instead of resumeUrl

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(Long applicationId, JobPosting jobPosting, JobSeekerProfile jobSeekerProfile,
			LocalDate applicationDate, ApplicationStatus status, Resume resume) {
		super();
		this.applicationId = applicationId;
		this.jobPosting = jobPosting;
		this.jobSeekerProfile = jobSeekerProfile;
		this.applicationDate = applicationDate;
		this.status = status;
		this.resume = resume;
	}

	public Application(JobPosting jobPosting, JobSeekerProfile jobSeekerProfile,
			ApplicationStatus status, Resume resume) {
		super();
		this.jobPosting = jobPosting;
		this.jobSeekerProfile = jobSeekerProfile;
		this.status = status;
		this.resume = resume;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public JobPosting getJobPosting() {
		return jobPosting;
	}

	public void setJobPosting(JobPosting jobPosting) {
		this.jobPosting = jobPosting;
	}

	public JobSeekerProfile getJobSeekerProfile() {
		return jobSeekerProfile;
	}

	public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
		this.jobSeekerProfile = jobSeekerProfile;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", jobPosting=" + jobPosting + ", jobSeekerProfile="
				+ jobSeekerProfile + ", applicationDate=" + applicationDate + ", status=" + status + ", resume="
				+ resume + "]";
	}

    // Getters, Setters, Constructors
    
}


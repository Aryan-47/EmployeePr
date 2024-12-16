package com.hexaware.CareerCrafterApplication.models;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RecommendedJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendedId;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobPosting jobPosting;

    @ManyToOne
    @JoinColumn(name = "job_seeker_profile_id", nullable = false)
    private JobSeekerProfile jobSeeker;

    private String reason; // Optional: explanation of why this job was recommended
    

	public RecommendedJobs() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RecommendedJobs(Long recommendedId, JobPosting jobPosting, JobSeekerProfile jobSeeker, String reason) {
		super();
		this.recommendedId = recommendedId;
		this.jobPosting = jobPosting;
		this.jobSeeker = jobSeeker;
		this.reason = reason;
	}
	


	public RecommendedJobs(JobPosting jobPosting, JobSeekerProfile jobSeeker, String reason) {
		super();
		this.jobPosting = jobPosting;
		this.jobSeeker = jobSeeker;
		this.reason = reason;
	}


	public Long getRecommendedId() {
		return recommendedId;
	}


	public void setRecommendedId(Long recommendedId) {
		this.recommendedId = recommendedId;
	}


	public JobPosting getJobPosting() {
		return jobPosting;
	}


	public void setJobPosting(JobPosting jobPosting) {
		this.jobPosting = jobPosting;
	}


	public JobSeekerProfile getJobSeeker() {
		return jobSeeker;
	}


	public void setJobSeeker(JobSeekerProfile jobSeeker) {
		this.jobSeeker = jobSeeker;
	}



	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	@Override
	public String toString() {
		return "RecommendedJobs [recommendedId=" + recommendedId + ", jobPosting=" + jobPosting + ", jobSeeker="
				+ jobSeeker + ", reason=" + reason + "]";
	}
	
    
    

    // Getters, Setters, Constructors, etc.
}

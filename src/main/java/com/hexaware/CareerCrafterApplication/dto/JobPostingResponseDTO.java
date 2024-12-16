package com.hexaware.CareerCrafterApplication.dto;

import java.time.LocalDate;

public class JobPostingResponseDTO {
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String location;
    private String requiredSkills;
    private String employmentType;
    private String salaryRange;
    private LocalDate postedDate;
    private LocalDate applicationDeadline;
    private boolean status;
    private String employerEmail;
    private String companyName; // New field for company name

    // Getters and Setters
    public JobPostingResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    

    public JobPostingResponseDTO(Long jobId, String jobTitle, String jobDescription, String location,
			String requiredSkills, String employmentType, String salaryRange, LocalDate postedDate,
			LocalDate applicationDeadline, boolean status, String employerEmail, String companyName) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.location = location;
		this.requiredSkills = requiredSkills;
		this.employmentType = employmentType;
		this.salaryRange = salaryRange;
		this.postedDate = postedDate;
		this.applicationDeadline = applicationDeadline;
		this.status = status;
		this.employerEmail = employerEmail;
		this.companyName = companyName;
	}


	public Long getJobId() {
        return jobId;
    }

	public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public LocalDate getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(LocalDate applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

    public String getEmployerEmail() {
		return employerEmail;
	}



	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}



	public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



	@Override
	public String toString() {
		return "JobPostingResponseDTO [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
				+ ", location=" + location + ", requiredSkills=" + requiredSkills + ", employmentType=" + employmentType
				+ ", salaryRange=" + salaryRange + ", postedDate=" + postedDate + ", applicationDeadline="
				+ applicationDeadline + ", status=" + status + ", employerEmail=" + employerEmail + ", companyName="
				+ companyName + "]";
	}
    
    
}

package com.hexaware.CareerCrafterApplication.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String jobTitle;
    private String jobDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false)
    private CompanyLocation location; // Location entity reference

    private String requiredSkills;
    private String employmentType; // Full-time, Part-time, etc.
    private String salaryRange; // e.g., "50000-70000"

    private LocalDate postedDate; // Date job was posted
    private LocalDate applicationDeadline; // Deadline for application submissions

    private boolean status; // true for active, false for inactive

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_profile_id", nullable = false)
    private EmployerProfile employerProfile; // Reference to the employer

    public JobPosting() {
    }

    public JobPosting(String jobTitle, String jobDescription, CompanyLocation location, String requiredSkills,
                      String employmentType, String salaryRange, LocalDate postedDate,
                      LocalDate applicationDeadline, boolean status, EmployerProfile employerProfile) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.location = location;
        this.requiredSkills = requiredSkills;
        this.employmentType = employmentType;
        this.salaryRange = salaryRange;
        this.postedDate = postedDate;
        this.applicationDeadline = applicationDeadline;
        this.status = status;
        this.employerProfile = employerProfile;
    }

    // Getters and Setters
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

    public CompanyLocation getLocation() {
        return location;
    }

    public void setLocation(CompanyLocation location) {
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

    public EmployerProfile getEmployerProfile() {
        return employerProfile;
    }

    public void setEmployerProfile(EmployerProfile employerProfile) {
        this.employerProfile = employerProfile;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", location=" + location +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", postedDate=" + postedDate +
                ", applicationDeadline=" + applicationDeadline +
                ", status=" + status +
                ", employerProfile=" + (employerProfile != null ? employerProfile.getEmployerId() : null) +
                '}';
    }
}

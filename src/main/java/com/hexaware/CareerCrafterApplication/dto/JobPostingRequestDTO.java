package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class JobPostingRequestDTO {

    @NotBlank(message = "Job title cannot be blank")
    @Size(max = 100, message = "Job title cannot exceed 100 characters")
    private String jobTitle;

    @NotBlank(message = "Job description cannot be blank")
    @Size(max = 1000, message = "Job description cannot exceed 1000 characters")
    private String jobDescription;

    @NotNull(message = "Location ID cannot be null")
    private Long locationId; // ID of the existing location

    @NotBlank(message = "Required skills cannot be blank")
    private String requiredSkills;

    @NotBlank(message = "Employment type cannot be blank")
    @Pattern(regexp = "Full-time|Part-time|Internship", 
             message = "Employment type must be one of: Full-time, Part-time, Internship")
    private String employmentType;

    @Pattern(regexp = "\\d{4,7}-\\d{4,7}", 
             message = "Salary range must be in the format 'min-max' with numeric values (e.g., '50000-70000')")
    private String salaryRange;

    @NotNull(message = "Application deadline cannot be null")
    @Future(message = "Application deadline must be in the future")
    private LocalDate applicationDeadline;

    @NotNull(message = "Status cannot be null")
    private boolean status; // true for active, false for inactive

    @NotNull(message = "Employer ID cannot be null")
    private Long employerId; // ID of the employer

    // Getters and Setters

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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }
}

package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ExperienceDTO {

    @NotBlank(message = "Job title cannot be blank")
    @Size(max = 100, message = "Job title cannot exceed 100 characters")
    private String jobTitle;

    @NotBlank(message = "Company name cannot be blank")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String companyName;

    @NotNull(message = "Duration cannot be null")
    @DecimalMin(value = "0.1", inclusive = true, message = "Duration must be at least 0.1 years")
    private Double duration; // Use ISO format for date

    @NotBlank(message = "Responsibilities cannot be blank")
    @Size(max = 500, message = "Responsibilities cannot exceed 500 characters")
    private String responsibilities;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String jobTitle, String companyName, Double duration, String responsibilities) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.duration = duration;
        this.responsibilities = responsibilities;
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

    @Override
    public String toString() {
        return "ExperienceDTO [jobTitle=" + jobTitle + ", companyName=" + companyName + ", duration=" + duration
                + ", responsibilities=" + responsibilities + "]";
    }
}

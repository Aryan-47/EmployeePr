package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class ApplicationResponseDTO {
    @NotNull(message = "Application ID cannot be null")
    private Long applicationId;

    @NotNull(message = "Job ID cannot be null")
    private Long jobId;

    @NotNull(message = "Job Seeker ID cannot be null")
    private Long jobSeekerId;

    @NotNull(message = "Resume ID cannot be null")
    private Long resumeId;

    @NotNull(message = "Application date cannot be null")
    @PastOrPresent(message = "Application date must be in the past or present")
    private LocalDate applicationDate;

    @NotBlank(message = "Status cannot be blank")
    @Pattern(regexp = "PENDING|REVIEWED|ACCEPTED|REJECTED", message = "Status must be one of PENDING, REVIEWED, ACCEPTED, or REJECTED")
    private String status; // Status as String (PENDING, REVIEWED, ACCEPTED, REJECTED)

    public ApplicationResponseDTO() {
    }

    public ApplicationResponseDTO(Long applicationId, Long jobId, Long jobSeekerId, Long resumeId, LocalDate applicationDate, String status) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.jobSeekerId = jobSeekerId;
        this.resumeId = resumeId;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

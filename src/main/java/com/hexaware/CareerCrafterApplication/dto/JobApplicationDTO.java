package com.hexaware.CareerCrafterApplication.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class JobApplicationDTO {
    @NotNull(message = "Job ID cannot be null")
    private Long jobId;

    @NotNull(message = "Job Seeker ID cannot be null")
    private Long jobSeekerId;

    @NotNull(message = "Resume ID cannot be null")
    private Long resumeId; // Resume reference

    @NotNull(message = "Application date cannot be null")
    private LocalDate applicationDate;

    public JobApplicationDTO() {
    }

    public JobApplicationDTO(Long jobId, Long jobSeekerId, Long resumeId, LocalDate applicationDate) {
        this.jobId = jobId;
        this.jobSeekerId = jobSeekerId;
        this.resumeId = resumeId;
        this.applicationDate = applicationDate;
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
}

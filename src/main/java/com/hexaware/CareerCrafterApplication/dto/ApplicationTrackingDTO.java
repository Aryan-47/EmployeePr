package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ApplicationTrackingDTO {
    @NotNull(message = "Application ID cannot be null")
    private Long applicationId;

    @NotNull(message = "Job Seeker ID cannot be null")
    private Long jobSeekerId;

    @NotNull(message = "Job ID cannot be null")
    private Long jobId;

    @NotBlank(message = "Status cannot be blank")
    @Pattern(regexp = "PENDING|REVIEWED|ACCEPTED|REJECTED", 
             message = "Status must be one of PENDING, REVIEWED, ACCEPTED, or REJECTED")
    private String status;

    public ApplicationTrackingDTO() {}

    public ApplicationTrackingDTO(Long applicationId, Long jobSeekerId, Long jobId, String status) {
        this.applicationId = applicationId;
        this.jobSeekerId = jobSeekerId;
        this.jobId = jobId;
        this.status = status;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApplicationTrackingDTO [applicationId=" + applicationId + ", jobSeekerId=" + jobSeekerId + ", jobId="
                + jobId + ", status=" + status + "]";
    }
}

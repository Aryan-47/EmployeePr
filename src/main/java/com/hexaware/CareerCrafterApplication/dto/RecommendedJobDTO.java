package com.hexaware.CareerCrafterApplication.dto;

import java.time.LocalDateTime;

public class RecommendedJobDTO {
    
    private Long recommendedId;       // ID of the recommendation
    private Long jobId;               // ID of the recommended job
    private String jobTitle;          // Title of the job
    private String companyName;       // Name of the company offering the job
    private String location;          // Location of the job
    private String requiredSkills;    // Required skills for the job
    private String reason;            // Reason for recommendation

    public RecommendedJobDTO() {
    }

    public RecommendedJobDTO(Long recommendedId, Long jobId, String jobTitle, String companyName, 
                              String location, String requiredSkills, String reason) {
        this.recommendedId = recommendedId;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.location = location;
        this.requiredSkills = requiredSkills;
        this.reason = reason;
    }

    // Getters and Setters
    public Long getRecommendedId() {
        return recommendedId;
    }

    public void setRecommendedId(Long recommendedId) {
        this.recommendedId = recommendedId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public String toString() {
        return "RecommendedJobDTO{" +
                "recommendedId=" + recommendedId +
                ", jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", reason='" + reason + '\'' +
                +
                '}';
    }
}

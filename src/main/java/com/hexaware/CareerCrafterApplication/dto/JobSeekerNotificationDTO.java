package com.hexaware.CareerCrafterApplication.dto;

import java.time.LocalDateTime;

public class JobSeekerNotificationDTO {

    private Long jobSeekerId;
    private String message;
    private LocalDateTime sentAt;
    private String type; // Enum for notification type
    private boolean isRead;

    
    public JobSeekerNotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobSeekerNotificationDTO(Long jobSeekerId, String message, LocalDateTime sentAt, String type, boolean isRead) {
        this.jobSeekerId = jobSeekerId;
        this.message = message;
        this.sentAt = sentAt;
        this.type = type;
        this.isRead = isRead;
    }

    // Getters and Setters
    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
}

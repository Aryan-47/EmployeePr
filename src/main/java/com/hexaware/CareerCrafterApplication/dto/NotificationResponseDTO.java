package com.hexaware.CareerCrafterApplication.dto;

import java.time.LocalDateTime;

public class NotificationResponseDTO {
    private Long notificationId;
    private Long jobSeekerId; // Include Job Seeker ID
    private String message;
    private LocalDateTime sentAt;
    private String type; // Enum mapped to String

    public NotificationResponseDTO() {
    }

    public NotificationResponseDTO(Long notificationId, Long jobSeekerId, String message, LocalDateTime sentAt, String type) {
        this.notificationId = notificationId;
        this.jobSeekerId = jobSeekerId;
        this.message = message;
        this.sentAt = sentAt;
        this.type = type;
    }

    // Getters and Setters

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

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
}

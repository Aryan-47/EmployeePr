package com.hexaware.CareerCrafterApplication.models;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobSeekerNotification {
	
	public enum NotificationType {
	    JOB_RECOMMENDATION,
	    JOB_APPLICATION,
	    GENERAL
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeekerProfile jobSeeker;

    private String message;
    private LocalDateTime sentAt;

    @Enumerated(EnumType.STRING)
    private NotificationType type; // Uses the enum for notification type

    private boolean isRead;

    public JobSeekerNotification() {}

    public JobSeekerNotification(JobSeekerProfile jobSeeker, String message, LocalDateTime sentAt, NotificationType type, boolean isRead) {
        this.jobSeeker = jobSeeker;
        this.message = message;
        this.sentAt = sentAt;
        this.type = type;
        this.isRead = isRead;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobSeekerProfile getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeekerProfile jobSeeker) {
        this.jobSeeker = jobSeeker;
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

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
}

package com.hexaware.CareerCrafterApplication.dto;

import java.time.LocalDateTime;

public class EmployerNotificationDTO {
	private Long notificationID;
    private Long employerId;
    private String message;
    private LocalDateTime sentAt;
    private String type;
    private boolean isRead;
    
    
    
    public EmployerNotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployerNotificationDTO(Long notificationID, Long employerId, String message, LocalDateTime sentAt,
			String type) {
		super();
		this.notificationID = notificationID;
		this.employerId = employerId;
		this.message = message;
		this.sentAt = sentAt;
		this.type = type;
	}

	public EmployerNotificationDTO(Long employerId, String message, LocalDateTime sentAt, 
                                   String type, boolean isRead) {
        this.employerId = employerId;
        this.message = message;
        this.sentAt = sentAt;
        this.type = type;
        this.isRead = isRead;
    }
	
	

    public Long getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(Long notificationID) {
		this.notificationID = notificationID;
	}

	// Getters and Setters
    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
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

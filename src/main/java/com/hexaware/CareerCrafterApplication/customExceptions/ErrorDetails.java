package com.hexaware.CareerCrafterApplication.customExceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime t;
	private String message;
	private String path;
	private String errorCode;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(LocalDateTime t, String message, String path, String errorCode) {
		super();
		this.t = t;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}
	
	
	public LocalDateTime getT() {
		return t;
	}
	public void setT(LocalDateTime t) {
		this.t = t;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ErrorDetails [t=" + t + ", message=" + message + ", path=" + path + ", errorCode=" + errorCode + "]";
	}
	
	
	
}


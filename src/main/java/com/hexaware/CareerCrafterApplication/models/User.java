package com.hexaware.CareerCrafterApplication.models;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
	
	public enum Role {
	    JOB_SEEKER, EMPLOYER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	

	public User(long userID, String username, String password, Role role) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.role = role;
	}



	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	

	
}

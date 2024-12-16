package com.hexaware.CareerCrafterApplication.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {
    private String username;
    private String role;

    public UserDTO() {
    }
    
    

    public UserDTO(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}



	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", role=" + role + "]";
	}
    
    

}


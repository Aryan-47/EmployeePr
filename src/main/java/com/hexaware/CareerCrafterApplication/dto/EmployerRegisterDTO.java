package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployerRegisterDTO {
    
    @NotNull(message = "Username cannot be null")
    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,20}$", message = "Username must be 3-20 characters long and can include letters, numbers, dots, underscores, and hyphens")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Please provide a valid email address")
    private String email;

    public EmployerRegisterDTO() {
        super();
    }

    public EmployerRegisterDTO(String username, String password, String email) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployerRegisterDTO [username=" + username + ", password=" + password + ", email=" + email + "]";
    }
}

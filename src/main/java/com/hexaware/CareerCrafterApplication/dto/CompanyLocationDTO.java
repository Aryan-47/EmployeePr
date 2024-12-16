package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CompanyLocationDTO {

    @NotNull(message = "Location ID cannot be null")
    private Long locationId;

    @NotNull(message = "Company ID cannot be null")
    private Long companyId;

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 50, message = "City cannot exceed 50 characters")
    private String city;

    @NotBlank(message = "State cannot be blank")
    @Size(max = 50, message = "State cannot exceed 50 characters")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    @Size(max = 50, message = "Country cannot exceed 50 characters")
    private String country;

    // Default constructor
    public CompanyLocationDTO() {
    }

    // Constructor with parameters
    public CompanyLocationDTO(Long locationId, Long companyId, String address, String city, String state, String country) {
        this.locationId = locationId;
        this.companyId = companyId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public CompanyLocationDTO(Long companyId, String address, String city, String state, String country) {
        this.companyId = companyId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters and Setters
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CompanyLocationDTO [locationId=" + locationId + ", companyId=" + companyId + ", address=" + address
                + ", city=" + city + ", state=" + state + ", country=" + country + "]";
    }
}

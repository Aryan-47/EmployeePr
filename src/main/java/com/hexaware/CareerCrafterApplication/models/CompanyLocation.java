package com.hexaware.CareerCrafterApplication.models;

import jakarta.persistence.*;

@Entity
public class CompanyLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId; // Primary Key

    private String city; // City of the location
    private String state; // State of the location
    private String country; // Country of the location

    public CompanyLocation() {
    }

    public CompanyLocation(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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
        return "Location{" +
                "locationId=" + locationId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

package com.hexaware.CareerCrafterApplication.models;

import jakarta.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId; // Primary Key

    private String companyName; // Name of the company
    private String industry; // Industry of the company
    private String website; // Website URL of the company

    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "location_id", nullable = false)
    private CompanyLocation location; // Foreign key to Location entity

    public Company() {
    }

    public Company(String companyName, String industry, String website, CompanyLocation location) {
        this.companyName = companyName;
        this.industry = industry;
        this.website = website;
        this.location = location;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public CompanyLocation getLocation() {
        return location;
    }

    public void setLocation(CompanyLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", website='" + website + '\'' +
                ", location=" + location +
                '}';
    }
}

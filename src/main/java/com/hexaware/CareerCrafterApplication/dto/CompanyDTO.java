package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CompanyDTO {

    @NotBlank(message = "Company name cannot be blank")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String companyName; // Name of the company

    @NotNull(message = "Company location cannot be null")
    @Valid
    private LocationDTO companyLocation; // Location of the company (using LocationDTO)

    @NotBlank(message = "Industry cannot be blank")
    @Size(max = 50, message = "Industry cannot exceed 50 characters")
    private String industry; // Industry of the company

    private String website; // Website URL of the company

    public CompanyDTO() {
    }

    public CompanyDTO(String companyName, LocationDTO companyLocation, String industry, String website) {
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.industry = industry;
        this.website = website;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocationDTO getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(LocationDTO companyLocation) {
        this.companyLocation = companyLocation;
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

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "companyName='" + companyName + '\'' +
                ", companyLocation=" + companyLocation +
                ", industry='" + industry + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}

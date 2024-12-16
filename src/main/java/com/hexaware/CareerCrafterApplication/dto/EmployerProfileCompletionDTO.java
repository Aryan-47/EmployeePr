package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class EmployerProfileCompletionDTO {

    @NotNull(message = "Employer ID cannot be null")
    private Long employerId; // ID of the employer profile

    @NotNull(message = "Company details cannot be null")
    @Valid
    private CompanyDTO company; // Company details encapsulated in CompanyDTO

    public EmployerProfileCompletionDTO() {
    }

    public EmployerProfileCompletionDTO(Long employerId, CompanyDTO company) {
        this.employerId = employerId;
        this.company = company;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "EmployerProfileCompletionDTO{" +
                "employerId=" + employerId +
                ", company=" + company +
                '}';
    }
}

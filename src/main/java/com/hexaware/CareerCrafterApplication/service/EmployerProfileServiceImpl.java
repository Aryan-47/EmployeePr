package com.hexaware.CareerCrafterApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.EmployerProfileCompletionDTO;
import com.hexaware.CareerCrafterApplication.models.Company;
import com.hexaware.CareerCrafterApplication.models.CompanyLocation;
import com.hexaware.CareerCrafterApplication.models.EmployerProfile;
import com.hexaware.CareerCrafterApplication.models.JobPosting;
import com.hexaware.CareerCrafterApplication.repository.CompanyRepository;
import com.hexaware.CareerCrafterApplication.repository.EmployerProfileRepository;

@Service
public class EmployerProfileServiceImpl implements IEmployerProfileService {

    @Autowired
    private EmployerProfileRepository employerProfileRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String completeProfile(EmployerProfileCompletionDTO employerProfileCompletionDTO) throws ResourceNotFoundException {
        // Fetch EmployerProfile by employerId
        EmployerProfile employerProfile = employerProfileRepository.findByEmployerId(employerProfileCompletionDTO.getEmployerId());
        if (employerProfile == null) {
            throw new ResourceNotFoundException("EmployerProfile", "employerId", employerProfileCompletionDTO.getEmployerId());
        }

        // Set company details (add logic to save company)
        Company company = new Company();
        company.setCompanyName(employerProfileCompletionDTO.getCompany().getCompanyName());
        company.setIndustry(employerProfileCompletionDTO.getCompany().getIndustry());
        company.setWebsite(employerProfileCompletionDTO.getCompany().getWebsite());

        CompanyLocation companyLocation = new CompanyLocation();
        companyLocation.setCity(employerProfileCompletionDTO.getCompany().getCompanyLocation().getCity());
        companyLocation.setState(employerProfileCompletionDTO.getCompany().getCompanyLocation().getState());
        companyLocation.setCountry(employerProfileCompletionDTO.getCompany().getCompanyLocation().getCountry());

        company.setLocation(companyLocation);

        // Save the company first
        Company savedCompany = companyRepository.save(company);

        // Set company to the employer profile
        employerProfile.setCompany(savedCompany);

        // Save the updated employer profile
        employerProfileRepository.save(employerProfile);

        return "Employer Profile completed successfully";
    }
}

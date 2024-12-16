package com.hexaware.CareerCrafterApplication.service;

import com.hexaware.CareerCrafterApplication.models.Company;
import com.hexaware.CareerCrafterApplication.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Get company by ID
    public Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }

    // Delete company by ID
    public boolean deleteCompanyById(Long companyId) {
        if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
            return true;
        }
        return false;
    }
}

package com.hexaware.CareerCrafterApplication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CareerCrafterApplication.models.Company;
import com.hexaware.CareerCrafterApplication.service.CompanyServiceImpl;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    // Get company by ID
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        Optional<Company> company = companyService.getCompanyById(companyId);
        return company.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete company by ID
    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Long companyId) {
        if (companyService.deleteCompanyById(companyId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

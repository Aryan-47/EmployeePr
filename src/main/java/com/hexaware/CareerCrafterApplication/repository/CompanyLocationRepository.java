package com.hexaware.CareerCrafterApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.Company;
import com.hexaware.CareerCrafterApplication.models.CompanyLocation;

@Repository
public interface CompanyLocationRepository extends JpaRepository<CompanyLocation, Long>{

}

package com.hexaware.CareerCrafterApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.EmployerProfile;

@Repository
public interface EmployerProfileRepository extends JpaRepository<EmployerProfile, Long>{
	public EmployerProfile findByEmployerId(Long employerId);
}

package com.hexaware.CareerCrafterApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.models.JobSeekerProfile;

@Repository
public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Long> {
    public JobSeekerProfile findByProfileId(Long userId); // Find a profile by user ID
}

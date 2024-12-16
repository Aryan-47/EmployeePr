package com.hexaware.CareerCrafterApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.CareerCrafterApplication.models.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
   public List<Application> findByJobPostingEmployerProfileEmployerId(Long employerId); // Fetch applications by employer
   public  List<Application> findByJobPostingJobId(Long jobId); // Fetch applications for a specific job posting
}

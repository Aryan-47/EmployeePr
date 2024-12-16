package com.hexaware.CareerCrafterApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.Application;

@Repository
public interface ApplicationTrackingRepository extends JpaRepository<Application, Long> {
    public List<Application> findByJobSeekerProfileProfileId(Long JobSeekerId);
}

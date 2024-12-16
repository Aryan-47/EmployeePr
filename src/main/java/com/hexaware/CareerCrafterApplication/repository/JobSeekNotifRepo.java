package com.hexaware.CareerCrafterApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.JobSeekerNotification;

@Repository
public interface JobSeekNotifRepo extends JpaRepository<JobSeekerNotification, Long> {
	List<JobSeekerNotification> findByJobSeekerProfileId(Long jobSeekerId);

}

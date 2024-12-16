package com.hexaware.CareerCrafterApplication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.RecommendedJobs;

@Repository
public interface RecommendedJobsRepository extends JpaRepository<RecommendedJobs, Long> {
	List<RecommendedJobs> findByJobSeekerProfileId(Long profileId);
}

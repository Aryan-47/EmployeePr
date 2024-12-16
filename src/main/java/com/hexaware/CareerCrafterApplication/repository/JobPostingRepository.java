package com.hexaware.CareerCrafterApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
	@Query(value = "select * from job_posting where job_posting.status = true",
			    nativeQuery = true
			)
	public List<JobPosting> findAllActiveJobs();
}

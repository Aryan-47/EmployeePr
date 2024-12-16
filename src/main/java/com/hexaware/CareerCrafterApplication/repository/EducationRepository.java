package com.hexaware.CareerCrafterApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.Education;


@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}


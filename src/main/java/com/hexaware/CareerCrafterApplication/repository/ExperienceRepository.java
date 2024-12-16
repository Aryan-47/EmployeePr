package com.hexaware.CareerCrafterApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}

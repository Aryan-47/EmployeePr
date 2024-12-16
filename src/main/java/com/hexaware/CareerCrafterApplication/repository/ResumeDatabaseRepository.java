package com.hexaware.CareerCrafterApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.Resume;

@Repository
public interface ResumeDatabaseRepository extends JpaRepository<Resume, Long> {
}


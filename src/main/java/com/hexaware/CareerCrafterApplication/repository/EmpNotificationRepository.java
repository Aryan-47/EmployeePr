package com.hexaware.CareerCrafterApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CareerCrafterApplication.models.EmployerNotification;

@Repository
public interface EmpNotificationRepository extends JpaRepository<EmployerNotification, Long> {
    // Custom query to find notifications by employerId and type
    List<EmployerNotification> findByEmployerEmployerId(Long employerId);
}

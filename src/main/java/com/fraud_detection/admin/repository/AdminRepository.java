package com.fraud_detection.admin.repository;

import com.fraud_detection.admin.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface AdminRepository extends JpaRepository<UserDetailsEntity, String> {
    // Custom query methods can be defined here if needed
    // For example, to find a user by their email ID or account number
    List<UserDetailsEntity> findByFraudDetailsIsNotNull();
}

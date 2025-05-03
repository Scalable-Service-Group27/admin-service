package com.fraud_detection.admin.repository;

import com.fraud_detection.admin.entity.TransactionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface TransactionLogRepository extends JpaRepository<TransactionLogEntity, String> {
    // Custom query methods can be defined here if needed
    // For example, to find a user by their email ID or account number
    // AdminRepository.java
    List<TransactionLogEntity> findByStatus(String status);
    Optional<TransactionLogEntity> findByTransactionId(String transactionId);


}

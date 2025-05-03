package com.fraud_detection.admin.service;

import com.fraud_detection.admin.entity.TransactionLogEntity;
import com.fraud_detection.admin.repository.TransactionLogRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2

public class AdminService {
    @Autowired
    private TransactionLogRepository transactionLogRepository;

    // Fetch all users with fraud details
    // AdminService.java
    public List<TransactionLogEntity> getByStatus(String status) {
        return transactionLogRepository.findByStatus(status);
    }

    // Update the 'opencase' column for a specific user
    public List<TransactionLogEntity> getAllTransactions() {
        return transactionLogRepository.findAll();
    }

    public TransactionLogEntity updateCaseOpen(String transactionId, String caseOpenStatus) {
        TransactionLogEntity transaction = transactionLogRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + transactionId));
        transaction.setCaseOpened(caseOpenStatus);
        return transactionLogRepository.save(transaction);
    }
    public TransactionLogEntity updateStatusAndCaseOpen(String transactionId, String caseOpenStatus) {
        TransactionLogEntity transaction = transactionLogRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + transactionId));
        if ("ALERT".equalsIgnoreCase(transaction.getStatus())) {
            transaction.setStatus("FRAUD");
        }
        transaction.setCaseOpened(caseOpenStatus);
        return transactionLogRepository.save(transaction);
    }
}



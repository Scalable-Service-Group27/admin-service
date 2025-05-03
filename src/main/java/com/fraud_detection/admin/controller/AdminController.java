package com.fraud_detection.admin.controller;

import com.fraud_detection.admin.entity.TransactionLogEntity;
import com.fraud_detection.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // GET API to fetch fraud details
    @GetMapping("/transactions/status/{status}")
    public ResponseEntity<List<TransactionLogEntity>> getByStatus(@PathVariable String status) {
        List<TransactionLogEntity> transactions = adminService.getByStatus(status);
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionLogEntity>> getAllTransactions() {
        List<TransactionLogEntity> transactions = adminService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
    @PutMapping("/transactions/{transactionId}/case-open")
    public ResponseEntity<TransactionLogEntity> updateCaseOpen(
            @PathVariable String transactionId,
            @RequestParam String caseOpenStatus) {
        TransactionLogEntity updatedTransaction = adminService.updateCaseOpen(transactionId, caseOpenStatus);
        return ResponseEntity.ok(updatedTransaction);
    }
    @PutMapping("/transactions/{transactionId}/update-status-and-case-open")
    public ResponseEntity<TransactionLogEntity> updateStatusAndCaseOpen(
            @PathVariable String transactionId,
            @RequestParam(required = false) String caseOpenStatus) {
        TransactionLogEntity updatedTransaction = adminService.updateStatusAndCaseOpen(transactionId, caseOpenStatus);
        return ResponseEntity.ok(updatedTransaction);
    }

}
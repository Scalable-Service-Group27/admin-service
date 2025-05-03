package com.fraud_detection.admin.controller;

import com.fraud_detection.admin.entity.UserDetailsEntity;
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
    @GetMapping("/fraud-details")
    public ResponseEntity<List<UserDetailsEntity>> getFraudDetails() {
        List<UserDetailsEntity> fraudDetails = adminService.getFraudDetails();
        return ResponseEntity.ok(fraudDetails);
    }

    // POST API to update the 'opencase' column
    @PostMapping("/update-opencase/{userId}")
    public ResponseEntity<UserDetailsEntity> updateOpenCase(
            @PathVariable String userId,
            @RequestParam boolean isFraud) {
        UserDetailsEntity updatedUser = adminService.updateOpenCase(userId, isFraud);
        return ResponseEntity.ok(updatedUser);
    }
}
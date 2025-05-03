package com.fraud_detection.admin.service;

import com.fraud_detection.admin.entity.UserDetailsEntity;
import com.fraud_detection.admin.repository.AdminRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2

public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // Fetch all users with fraud details
    public List<UserDetailsEntity> getFraudDetails() {
        return adminRepository.findByFraudDetailsIsNotNull();
    }

    // Update the 'opencase' column for a specific user
    public UserDetailsEntity updateOpenCase(String userId, boolean isFraud) {
        UserDetailsEntity user = adminRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        user.setCaseopened(isFraud ? "YES" : "NO");
        return adminRepository.save(user);
    }
}



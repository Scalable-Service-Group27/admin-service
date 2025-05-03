package com.fraud_detection.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction_logs")
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Getter
@Setter


public class TransactionLogEntity {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "case_opened")
    private String CaseOpened;
    @Column(name = "status")
    private String Status;

}

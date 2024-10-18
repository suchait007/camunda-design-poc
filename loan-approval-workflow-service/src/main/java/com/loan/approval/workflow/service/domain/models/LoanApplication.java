package com.loan.approval.workflow.service.domain.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "LOAN_APPLICATION", schema = "credit_products_db")
public class LoanApplication {

    @Id
    @Column(name = "LOAN_ID")
    private String loanId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "LOAN_APPLICATION_STATUS")
    private String loanApplicationStatus;

    @Column(name = "credit_score")
    private Integer creditScore;

    @CreationTimestamp
    private String createdTime;

    @UpdateTimestamp
    private String updatedTime;
}

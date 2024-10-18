package com.score.credit.service.domain.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_CREDIT_SCORE", schema = "credit_products_db")
public class CreditScore {

    @Id
    @Column(name = "CREDIT_ID")
    private String creditScoreId;

    @Column(name = "USER_ID")
    private String userId;

    private Integer score;

    private String createdTime;
    private String updatedTime;
}

package com.loan.approval.workflow.service.infrastructure.openfeign.creditscore.dtos;


import lombok.Data;

@Data
public class CreditScoreDTO {

    private String creditScoreId;
    private Integer score;
    private String createdTime;
}

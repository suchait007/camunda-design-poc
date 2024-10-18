package com.score.credit.service.application.dtos;


import lombok.Data;

@Data
public class CreditScoreDTO {

    private String creditScoreId;
    private Integer score;
    private String createdTime;
}

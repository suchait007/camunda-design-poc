package com.score.credit.service.domain.services;


import com.score.credit.service.application.dtos.CreditScoreDTO;
import com.score.credit.service.domain.models.CreditScore;

public interface CreditScoreService {
    public CreditScoreDTO getCreditScore(String userId);

}

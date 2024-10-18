package com.score.credit.service.domain.services.impl;

import com.score.credit.service.application.dtos.CreditScoreDTO;
import com.score.credit.service.domain.models.CreditScore;
import com.score.credit.service.domain.services.CreditScoreService;
import com.score.credit.service.infrastructure.persistence.CreditScoreRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreditScoreServiceImpl implements CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;

    @Override
    public CreditScoreDTO getCreditScore(String userId) {

        CreditScore creditScore = creditScoreRepository.findAllByUserId(userId);
        return getCreditScoreDTO(creditScore);
    }

    private CreditScoreDTO getCreditScoreDTO(CreditScore creditScore) {

        CreditScoreDTO creditScoreDTO = new CreditScoreDTO();

        creditScoreDTO.setScore(creditScore.getScore());
        creditScoreDTO.setCreditScoreId(creditScore.getCreditScoreId());
        creditScoreDTO.setCreatedTime(creditScore.getCreatedTime());

        return creditScoreDTO;
    }
}

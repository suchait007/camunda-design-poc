package com.score.credit.service.infrastructure.persistence;

import com.score.credit.service.domain.models.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditScoreRepository extends JpaRepository<CreditScore, String> {

    CreditScore findAllByUserId(String userId);
}

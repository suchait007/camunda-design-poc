package com.score.credit.service.infrastructure.config;

import com.score.credit.service.domain.services.CreditScoreService;
import com.score.credit.service.domain.services.impl.CreditScoreServiceImpl;
import com.score.credit.service.infrastructure.persistence.CreditScoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditScoreConfig {

    @Bean
    public CreditScoreService getCreditScoreService(final CreditScoreRepository creditScoreRepository) {
        return new CreditScoreServiceImpl(creditScoreRepository);
    }

}

package com.loan.approval.workflow.service.infrastructure.config;


import com.loan.approval.workflow.service.domain.service.LoanApplicationService;
import com.loan.approval.workflow.service.domain.service.LoanApplicationServiceImpl;
import com.loan.approval.workflow.service.infrastructure.persistence.repos.LoanApplicationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanConfig {

    @Bean
    public LoanApplicationService getLoanApplicationService(final LoanApplicationRepository loanApplicationRepository) {
        return new LoanApplicationServiceImpl(loanApplicationRepository);
    }
}

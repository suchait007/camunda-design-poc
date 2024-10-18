package com.loan.approval.workflow.service.domain.service;


import com.loan.approval.workflow.service.domain.models.LoanApplication;
import com.loan.approval.workflow.service.infrastructure.persistence.repos.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication createLoanApplication(LoanApplication loanApplication) {

        log.info("Creating loan application in database");
        return loanApplicationRepository.save(loanApplication);
    }
}

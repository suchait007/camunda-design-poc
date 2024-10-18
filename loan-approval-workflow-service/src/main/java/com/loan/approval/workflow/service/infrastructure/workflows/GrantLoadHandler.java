package com.loan.approval.workflow.service.infrastructure.workflows;


import com.loan.approval.workflow.service.domain.models.LoanApplication;
import com.loan.approval.workflow.service.infrastructure.persistence.repos.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Configuration
@ExternalTaskSubscription("loanGranter")
public class GrantLoadHandler implements ExternalTaskHandler {

    private final LoanApplicationRepository loanApplicationRepository;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        String loanId = externalTask.getVariable("loanId");
        String customerId = externalTask.getVariable("customerId");
        int creditScore = externalTask.getVariable("creditScore");

        log.info("GrantLoadHandler has been executed");

        Optional<LoanApplication> loanApplicationOptional = loanApplicationRepository.findById(loanId);

        if(loanApplicationOptional.isPresent()) {

            LoanApplication loanApplication = loanApplicationOptional.get();
            loanApplication.setLoanApplicationStatus("Approved");

            log.info("LoanApplication has been approved");
            loanApplicationRepository.save(loanApplication);
        }

        externalTaskService.complete(externalTask);

    }
}

package com.loan.approval.workflow.service.infrastructure.workflows;

import com.loan.approval.workflow.service.domain.models.LoanApplication;
import com.loan.approval.workflow.service.domain.service.LoanApplicationService;
import com.loan.approval.workflow.service.infrastructure.openfeign.creditscore.client.CreditScoreServiceClient;
import com.loan.approval.workflow.service.infrastructure.openfeign.creditscore.dtos.CreditScoreDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.context.annotation.Configuration;


@Slf4j
@RequiredArgsConstructor
@Configuration
@ExternalTaskSubscription("scoreProvider")
public class ScoreHandler implements ExternalTaskHandler {

    private final CreditScoreServiceClient creditScoreServiceClient;
    private final LoanApplicationService loanApplicationService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        log.info("ScoreHandler task has been executed");

        String userId = externalTask.getVariable("userId");

        CreditScoreDTO creditScoreDTO = creditScoreServiceClient.getSingleCreditScore(userId);

        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setUserId(userId);
        loanApplication.setLoanId(creditScoreDTO.getCreditScoreId());
        loanApplication.setCreditScore(creditScoreDTO.getScore());
        loanApplication.setLoanApplicationStatus("Pending");

        loanApplicationService.createLoanApplication(loanApplication);

        log.info("User has credit score {}", creditScoreDTO.getScore());

        VariableMap variables = Variables.createVariables();
        variables.put("loanId", loanApplication.getLoanId());
        variables.put("customerId", userId);
        variables.put("creditScore", creditScoreDTO.getScore());

        externalTaskService.complete(externalTask, variables);


    }
}

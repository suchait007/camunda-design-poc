package com.loan.approval.workflow.service.application.api;


import com.loan.approval.workflow.service.application.dto.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.dto.ProcessInstanceWithVariablesDto;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RequestMapping("/v1/loan-workflow")
@RequiredArgsConstructor
@RestController
public class LoanWorkflowController {

    private final ProcessDefinitionApi processDefinitionApi;

    @PostMapping("/start")
    public ResponseEntity<String> startLoanWorkflow(@RequestBody Customer customer) throws ApiException {

        Map<String, VariableValueDto> variables = new HashMap<>();
        variables.put(
                "userId",
                new VariableValueDto().value(customer.getUserId()).type("string"));

        ProcessInstanceWithVariablesDto processInstance = processDefinitionApi
                .startProcessInstanceByKey("loan_process", new StartProcessInstanceDto().variables(variables));

        log.info("Loan Workflow has been started");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Started process instance with id: " + processInstance.getId());

    }
}

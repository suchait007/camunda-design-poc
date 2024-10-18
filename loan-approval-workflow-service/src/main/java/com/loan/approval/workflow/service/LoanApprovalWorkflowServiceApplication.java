package com.loan.approval.workflow.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.loan.approval.workflow.service.infrastructure")
@SpringBootApplication
public class LoanApprovalWorkflowServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApprovalWorkflowServiceApplication.class, args);
	}

}

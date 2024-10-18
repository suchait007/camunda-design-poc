package com.loan.approval.workflow.service.infrastructure.openfeign.creditscore.client;


import com.loan.approval.workflow.service.infrastructure.openfeign.creditscore.dtos.CreditScoreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8092", value = "credit-score-service-feign-client", path = "/v1")
public interface CreditScoreServiceClient {

     @GetMapping("/credit-score")
     CreditScoreDTO getSingleCreditScore(@RequestParam("user_id") String userId);
}

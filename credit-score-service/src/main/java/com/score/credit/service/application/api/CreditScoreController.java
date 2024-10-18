package com.score.credit.service.application.api;


import com.score.credit.service.application.dtos.CreditScoreDTO;
import com.score.credit.service.domain.services.CreditScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CreditScoreController {

    private final CreditScoreService creditScoreService;

    @GetMapping("/credit-score")
    public CreditScoreDTO getSingleCreditScore(@RequestParam("user_id") String userId) {
        return creditScoreService.getCreditScore(userId);
    }
}

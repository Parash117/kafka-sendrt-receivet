package com.pgrg.demo.controller;

import com.pgrg.demo.model.CreditScore;
import com.pgrg.demo.repo.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-score")
public class CreditScoreController {

    @Autowired
    private CreditRepo creditRepo;

    @GetMapping("/user-id/{userId}")
    private CreditScore getCreditScoreByUserId(@PathVariable("userId") Integer userId) {
        CreditScore creditScore = creditRepo.getByUserId(userId);
        return creditRepo.getByUserId(userId);
    }
}

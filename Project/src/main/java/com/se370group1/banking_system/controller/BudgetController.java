package com.se370group1.banking_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.service.BankingFacadeService;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    private final BankingFacadeService bankingFacadeService;

    public BudgetController(BankingFacadeService bankingFacadeService) {
        this.bankingFacadeService = bankingFacadeService;
    }

    // Add budget endpoints here later
}
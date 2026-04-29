package com.se370group1.banking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.dto.TransactionDTO;
import com.se370group1.banking_system.service.BankingFacadeService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final BankingFacadeService bankingFacadeService;

    public TransactionController(BankingFacadeService bankingFacadeService) {
        this.bankingFacadeService = bankingFacadeService;
    }

    @RequestMapping("/getConnectedTransactions")
    public List<TransactionDTO> getConnectedTransactions(@RequestParam String targetConnectedUserID) {
        return bankingFacadeService.getTransactions(targetConnectedUserID);
    }

    @PostMapping("/transaction-from-form")
    public String handleTransaction(@ModelAttribute TransactionDTO transactionDTO) {
        return bankingFacadeService.handleTransaction(transactionDTO);
    }
}
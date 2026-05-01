package com.se370group1.banking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.dto.BankAccountDTO;
import com.se370group1.banking_system.service.BankingFacadeService;

@RestController
@RequestMapping("/api/bankAccount")
public class BankAccountController {

    private final BankingFacadeService bankingFacade;

    public BankAccountController(BankingFacadeService bankingFacade) {
        this.bankingFacade = bankingFacade;
    }

    @GetMapping("/getConnectedBankAccounts")
    public List<BankAccountDTO> getConnectedBankAccounts(@RequestParam String targetConnectedUserID) {
        return bankingFacade.getAccounts(targetConnectedUserID);
    }
    @PostMapping("/depositFunds")
    public Boolean depositFunds(
            @RequestParam String bankAccountID,
            @RequestParam double amount) {
        return bankingFacade.depositFunds(bankAccountID, amount);
    }

    @PostMapping("/withdrawFunds")
    public Boolean withdrawFunds(
            @RequestParam String bankAccountID,
            @RequestParam double amount) {
        return bankingFacade.withdrawFunds(bankAccountID, amount);
    }
@GetMapping("/transferFunds")
public Boolean transferFunds(
        @RequestParam String sourceAccountID,
        @RequestParam String targetAccountID,
        @RequestParam double amount) {

    return bankingFacade.transferFundsAndRecordTransaction(
            sourceAccountID,
            targetAccountID,
            amount
    );
}
}
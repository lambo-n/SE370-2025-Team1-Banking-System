package com.se370group1.banking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.dto.BankAccountDTO;
import com.se370group1.banking_system.service.BankAccountService;

@RestController
@RequestMapping("/api/bankAccount")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/getConnectedBankAccounts")
    public List<BankAccountDTO> getConnectedBankAccounts(@RequestParam String targetConnectedUserID) {
        System.out.println("getConnectedBankAccounts controller called with userID: " + targetConnectedUserID);
        
        //request to get a list of data transfer objects from bankAccountService.java
        //pass the targetConnectedUserID down to use for database searching
        List<BankAccountDTO> bankAccountDTOList = bankAccountService.getConnectedBankAccounts(targetConnectedUserID);

        //return the list back to app.js
        return bankAccountDTOList;
    }

    @GetMapping("/transferFunds")
    public Boolean transferFunds(
        @RequestParam String sourceAccountID, 
        @RequestParam String targetAccountID, 
        @RequestParam double amount
    ) {
        return bankAccountService.transferFunds(sourceAccountID, targetAccountID, amount);
    }
    
}
//controller handles incoming requests and delegates to service layer
//DTO's are used to transfer data between layers especially if the internal representation of data in the service layer differs from what the controller needs to expose.
//
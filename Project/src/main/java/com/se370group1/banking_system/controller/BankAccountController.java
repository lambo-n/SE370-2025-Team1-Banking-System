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
        
        List<BankAccountDTO> bankAccountDTOList = bankAccountService.getConnectedBankAccounts(targetConnectedUserID);

        return bankAccountDTOList;
    }
    
    
}

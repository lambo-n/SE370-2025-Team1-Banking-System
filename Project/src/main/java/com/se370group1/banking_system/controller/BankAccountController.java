package com.se370group1.banking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void getConnectedBankAccounts() {
        System.out.println("getConnectedBankAccounts controller called");

        String targetUserID = "1"; //TODO: replace with the actual user ID you want to check ---> turn it into a parameter
        List<BankAccountDTO> bankAccountDTOList = bankAccountService.getConnectedBankAccounts(targetUserID);

        //print list of bank accounts connected to the given target userID
        for (BankAccountDTO bankAccountDTO : bankAccountDTOList) {
            System.out.printf("Account ID: %s, Account Type: %s, Balance: %.2f\n",
                    bankAccountDTO.getBankAccountID(),
                    bankAccountDTO.getConnectedUserID(),
                    bankAccountDTO.getBalance());
        }

    }
    
}

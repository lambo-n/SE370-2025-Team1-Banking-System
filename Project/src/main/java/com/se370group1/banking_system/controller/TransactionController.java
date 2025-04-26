package com.se370group1.banking_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.dto.TransactionDTO;
import com.se370group1.banking_system.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService transactionService; //Transaction Service Object

    //constructor
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //returns list of transactions from connected account
    @RequestMapping("/getConnectedTransactions")
    public List<TransactionDTO> getConnectedTransactions(@RequestParam String targetConnectedUserID) {
        System.out.println("Retrieving transactions from account with user ID: " + targetConnectedUserID);
        List<TransactionDTO> transactionDTOList = transactionService.getTransactions(targetConnectedUserID);
        return transactionDTOList;
    }  
}

package com.se370group1.banking_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se370group1.banking_system.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //methods here
}

package com.se370group1.banking_system.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.se370group1.banking_system.model.BankAccount;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
    List<BankAccount> findConnectedBankAccounts(String userID);
}

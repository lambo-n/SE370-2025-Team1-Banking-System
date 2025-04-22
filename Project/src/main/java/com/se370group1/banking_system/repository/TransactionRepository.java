package com.se370group1.banking_system.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.se370group1.banking_system.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String>{
    List<Transaction> findByConnectedBankAccountID(String connectedBankAccountID);
}

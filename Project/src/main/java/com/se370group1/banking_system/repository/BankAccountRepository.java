package com.se370group1.banking_system.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.se370group1.banking_system.model.BankAccount;

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
    //simple search query using the target connectedUserID passed from bankAccountService.java
    List<BankAccount> findByConnectedUserID(String connectedUserID);
}

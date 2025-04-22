package com.se370group1.banking_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.se370group1.banking_system.model.Budget;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, String> {
    Budget findByConnectedUserID(String connectedUserID);
}

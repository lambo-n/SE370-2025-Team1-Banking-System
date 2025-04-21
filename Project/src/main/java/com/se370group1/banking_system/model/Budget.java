package com.se370group1.banking_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BudgetValues")
public class Budget {
    @Id
    private String budgetID;
    
    private String userID;
    private String budgetName;
    private double budgetAmount;


    
}

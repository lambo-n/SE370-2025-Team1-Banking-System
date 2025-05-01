package com.se370group1.banking_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se370group1.banking_system.dto.TransactionDTO;
import com.se370group1.banking_system.model.Transaction;
import com.se370group1.banking_system.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    /*
        1) validate transaction amount
        2) perform transaction
        3) handle errors

     */
    //methods here

    //completing transaction logic in the service layer
    public boolean validateTransactionAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transaction amount. Must be greater than 0.");
            return false;
        }
        double maxTransactionLimit = 10000.00;
        if (amount > maxTransactionLimit) {
            System.out.println("Invalid transaction amount. Your balance of " + amount + " exceeds the transaction limit of 10,000.00.");
            return false;
        }
        return true;
    }
    public List <TransactionDTO> getTransactions(String connectedUserID) {
        //create list to hold transactions
        List<Transaction> transactionList = transactionRepository.findByConnectedBankAccountID(connectedUserID);
        List<TransactionDTO> transactionDTOList = new ArrayList<>();
        
        //if there are no transactions in list
        if (transactionList.isEmpty()) {
            System.out.println("No transactions have been made on this account.");
        } else {
            //loop through transaction list for transactions
            //store values into a dto to pass to the controller
            for (Transaction temp_transaction : transactionList) {
                System.out.println("Extracting transaction id: " + temp_transaction.getTransactionID());
                TransactionDTO t_dto = new TransactionDTO(temp_transaction);
                transactionDTOList.add(t_dto);
            }
        }
        return transactionDTOList;
    }
    
    public TransactionDTO getMostRecentTransaction(List<TransactionDTO> dto) {
        if (dto.isEmpty()) {
            System.out.println("No transactions found.");
            return null;
        }
        
        //transactions are in a list where last inputted (aka most recent) is at the end
        TransactionDTO mostRecentDTO = dto.get(dto.size() - 1);
        return mostRecentDTO; 
    }

    public void processTransaction(TransactionDTO t_dto) {
        //create the pending transaction from controller
        Transaction pending_transaction = new Transaction(t_dto);
        //sends to database
        transactionRepository.save(pending_transaction);
    }

} //end of class

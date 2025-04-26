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

} //end of class

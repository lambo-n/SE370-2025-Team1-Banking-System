package com.se370group1.banking_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se370group1.banking_system.dto.BankAccountDTO;
import com.se370group1.banking_system.model.BankAccount;
import com.se370group1.banking_system.repository.BankAccountRepository;

@Service    
public class BankAccountService {
    @Autowired
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccountDTO> getConnectedBankAccounts(String connectedUserID) {
        List<BankAccount> bankAccountList = bankAccountRepository.findByConnectedUserID(connectedUserID);
        List<BankAccountDTO> bankAccountDTOList = new ArrayList<>();

        if(bankAccountList.isEmpty()) {
            System.out.println("No bank accounts found for user ID: " + connectedUserID);
        }
        else
        {
            for (BankAccount newBankAccount : bankAccountList) {
                BankAccountDTO dto = new BankAccountDTO(newBankAccount);
                bankAccountDTOList.add(dto);
            }
        }

        return bankAccountDTOList; 
    }
    
}

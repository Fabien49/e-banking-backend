package net.fabienit.ebankingbackend.services;

import net.fabienit.ebankingbackend.dtos.*;
import net.fabienit.ebankingbackend.entities.BankAccount;
import net.fabienit.ebankingbackend.entities.CurrentAccount;
import net.fabienit.ebankingbackend.entities.Customer;
import net.fabienit.ebankingbackend.entities.SavingAccount;
import net.fabienit.ebankingbackend.exceptions.BalanceNotSufficientException;
import net.fabienit.ebankingbackend.exceptions.BankAccountNotFoundException;
import net.fabienit.ebankingbackend.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount (double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount (double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfert(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}

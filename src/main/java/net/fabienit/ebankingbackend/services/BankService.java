package net.fabienit.ebankingbackend.services;

import jakarta.transaction.Transactional;
import net.fabienit.ebankingbackend.entities.BankAccount;
import net.fabienit.ebankingbackend.entities.CurrentAccount;
import net.fabienit.ebankingbackend.entities.SavingAccount;
import net.fabienit.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount = bankAccountRepository.findById("2397c6b4-b6d1-49e1-bb26-695893c03fba").orElse(null);
        if(bankAccount!=null) {
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft => " + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rates => " + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
            });
        }
    }
}

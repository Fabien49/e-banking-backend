package net.fabienit.ebankingbackend.repositories;

import net.fabienit.ebankingbackend.entities.BankAccount;
import net.fabienit.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}

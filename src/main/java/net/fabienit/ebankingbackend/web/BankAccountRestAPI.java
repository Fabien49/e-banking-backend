package net.fabienit.ebankingbackend.web;

import net.fabienit.ebankingbackend.dtos.AccountHistoryDTO;
import net.fabienit.ebankingbackend.dtos.AccountOperationDTO;
import net.fabienit.ebankingbackend.dtos.BankAccountDTO;
import net.fabienit.ebankingbackend.exceptions.BankAccountNotFoundException;
import net.fabienit.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankAccountRestAPI {

    public BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts/id")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccount(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
                                               @RequestParam(name = "page", defaultValue = "0") int page,
                                               @RequestParam(name = "size", defaultValue = "5")int size) throws BankAccountNotFoundException {
       return bankAccountService.getAccountHistory(accountId, page, size);
    }


}

package Com.AirMatios;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddAccountService {

    private final AccountRepository accountRepository;

    public AddAccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void AddAccount(String name, BigDecimal amount){

        accountRepository.add(name,amount);
    }
}

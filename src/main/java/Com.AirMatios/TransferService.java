package Com.AirMatios;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

   public Iterable<Account> transferMoney(long idSender, long idReceiver, BigDecimal amount){

        Account sender = accountRepository.findById(idSender).orElseThrow(()-> new AccountNotFoundException());
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(()-> new AccountNotFoundException());

        BigDecimal newSenderAmount = sender.getAmount().subtract(amount);
        BigDecimal newReceiverAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(idSender, newSenderAmount);
        accountRepository.changeAmount(idReceiver, newReceiverAmount);


       return accountRepository.findAll();

   }

   public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
   }


}

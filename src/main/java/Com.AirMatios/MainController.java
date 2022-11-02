package Com.AirMatios;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class MainController {

    private final TransferService transferService;
    private final AddAccountService addAccountService;
    private final TextFromAnotherBackend textFromAnotherBackend;
    private final Druczekz9090 druczekz9090;

    public MainController(TransferService transferService, AddAccountService addAccountService, TextFromAnotherBackend textFromAnotherBackend, Druczekz9090 druczekz9090) {
        this.transferService = transferService;
        this.addAccountService = addAccountService;
        this.textFromAnotherBackend = textFromAnotherBackend;
        this.druczekz9090 = druczekz9090;
    }


    @PostMapping("/add")
    public void addAccount(@RequestParam String name, BigDecimal amount){
        addAccountService.AddAccount(name,amount);

    }

    @GetMapping("/")
    public Iterable<Account> home(){
        return transferService.getAllAccounts();
    }

    @PostMapping("/")
    public Iterable<Account> transferMoney(@RequestBody TransferRequest transferRequest) {

        BigDecimal amount = transferRequest.getAmount();
        long receiverId = transferRequest.getReceiverId();
        long senderId = transferRequest.getSenderId();

        return transferService.transferMoney(senderId,receiverId,amount);


    }


    @GetMapping("/druk")
    public String printIt(){
        return   textFromAnotherBackend.printIt();

    }

    @PostMapping("/druczek")
    public String druczek(@RequestParam String druk){
        return   druczekz9090.druczek(druk);

    }
}

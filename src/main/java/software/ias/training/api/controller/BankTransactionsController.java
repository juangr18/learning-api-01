package software.ias.training.api.controller;

import org.springframework.web.bind.annotation.*;
import software.ias.training.api.domain.BankTransaction;
import software.ias.training.api.repository.TransactionsRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class BankTransactionsController {
    private final TransactionsRepository repository;

    public BankTransactionsController(TransactionsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> listTransactions() {
        return repository.listBankTransactions();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createTransaction(
            @RequestBody BankTransaction transaction
    ) {
        repository.createBankTransaction(transaction);
    }

    @RequestMapping(value = "/delete/{actual}", method = RequestMethod.DELETE)
    public void deleteTransaction(@PathVariable("actual") int actual){
        repository.deleteBankTransactions(actual);
    }

    @RequestMapping(value = "/update/{actual}", method = RequestMethod.PUT)
    public void updateTransaction(@PathVariable ("actual") int actual, @RequestBody BankTransaction transaction){
        repository.updateTransactions(actual, transaction);
    }


    @RequestMapping(value = "/filter/{date}", method = RequestMethod.GET)
    public void filterForDate(@RequestBody BankTransaction transaction, LocalDate date){
        repository.filterForDate(date, transaction);
    }
}

package software.ias.training.api.repository;

import org.springframework.stereotype.Repository;
import software.ias.training.api.domain.BankTransaction;
import software.ias.training.api.test.Database;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionsRepository {
    private final Database database;

    // dependency inversion
    public TransactionsRepository(Database database) {
        this.database = database;
    }


    public void createBankTransaction(BankTransaction transaction) {
        database.insertData(transaction);
    }

    public List<Object> listBankTransactions() {
        return database.listData();
    }

    public List<Object> deleteBankTransactions(int actual){ return database.deleteData(actual);}
    public List<Object> updateTransactions(int actual, BankTransaction transaction){
        return database.updateData(actual, transaction);
    }

    public List<Object> filterForDate(LocalDate date, BankTransaction transaction){
        return database.filterForDate(date, transaction);
    }
}

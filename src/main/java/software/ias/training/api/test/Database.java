package software.ias.training.api.test;

import org.springframework.stereotype.Component;
import software.ias.training.api.domain.BankTransaction;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Database {
    private final List<Object> data = new ArrayList<>();
    private final List<Object> listFilter= new ArrayList<>();

    public void insertData(Object item) {
        data.add(item);
    }

    public List<Object> listData() {
        return data;
    }


    @PostConstruct
    public void init() {
        data.add(
                new BankTransaction(LocalDate.now(), 100, "coffee")
        );

        data.add(
                new BankTransaction(LocalDate.now(), 150, "water")
        );
    }

    public List<Object> deleteData(int posicion){
        data.remove(posicion);
        return data;
    }
    public List<Object> updateData(int posicion, BankTransaction transaction){
        data.set(posicion, transaction);
        return  data;
    }
    public List<Object> filterForDate(LocalDate date, BankTransaction transaction){
        listFilter.add(transaction.getDate().equals(date));
        return listFilter;
    }
}

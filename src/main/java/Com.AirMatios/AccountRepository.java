package Com.AirMatios;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("INSERT INTO account(name,amount) VALUES (:name, :amount)")
    @Modifying
    void add(String name, BigDecimal amount);

    @Query("UPDATE account SET amount= :amount WHERE id= :id")
    @Modifying
    void changeAmount(Long id, BigDecimal amount);
}

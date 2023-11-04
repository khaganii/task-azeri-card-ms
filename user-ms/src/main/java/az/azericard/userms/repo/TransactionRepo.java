package az.azericard.userms.repo;

import az.azericard.userms.domain.Transaction;
import az.azericard.userms.domain.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query("SELECT s FROM  Transaction s WHERE userId = :id")
    List<Transaction> findAllByUserId(@Param("id") Long userId);
}

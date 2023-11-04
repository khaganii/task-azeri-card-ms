package az.azericard.userms.repo;

import az.azericard.userms.domain.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepo extends JpaRepository<UserCard, Long> {

    @Query("SELECT s FROM  UserCard s WHERE userId = :id and isEnable= :enable")
    List<UserCard> findAllByUserIdAndEnable(@Param("id") Long userId, @Param("enable") Boolean enable);

    @Query("SELECT s FROM  UserCard s WHERE userId = :id")
    List<UserCard> findAllByUserId(Long userId);
}

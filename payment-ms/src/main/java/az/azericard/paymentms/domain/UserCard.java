package az.azericard.paymentms.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "user_cards")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    Long cardId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    String cardNumber;
    LocalDate expirationDate;
    String cvv;
    BigDecimal balance;
}

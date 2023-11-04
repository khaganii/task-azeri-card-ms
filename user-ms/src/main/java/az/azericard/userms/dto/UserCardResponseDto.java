package az.azericard.userms.dto;

import az.azericard.userms.domain.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCardResponseDto {
    Long cardId;
    User user;
    String cardNumber;
    LocalDate expirationDate;
    Boolean isEnable;
    BigDecimal balance;
}

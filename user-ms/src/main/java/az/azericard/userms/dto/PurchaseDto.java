package az.azericard.userms.dto;

import az.azericard.userms.domain.Product;
import az.azericard.userms.domain.User;
import az.azericard.userms.domain.UserCard;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {
    Long userId;
    Long cardId;
    Long productId;
    Long productCount;
    LocalDateTime transactionDate;
    BigDecimal amount;
}

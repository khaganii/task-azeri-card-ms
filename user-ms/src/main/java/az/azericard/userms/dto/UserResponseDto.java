package az.azericard.userms.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    String name;
    String surname;
    String username;
    String email;
}

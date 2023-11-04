package az.azericard.userms.service;

import az.azericard.userms.config.HashingConfig;
import az.azericard.userms.domain.User;
import az.azericard.userms.domain.UserCard;
import az.azericard.userms.dto.UserCardRequestDto;
import az.azericard.userms.dto.UserCardResponseDto;
import az.azericard.userms.exception.ResourceNotFoundException;
import az.azericard.userms.repo.CardRepo;
import az.azericard.userms.repo.UserRepo;
import az.azericard.userms.utils.Mapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepo cardRepo;
    private final UserRepo userRepo;


    private final SecretKey secretKey;

    public List<UserCardResponseDto> getUserCardsByEnable(Long userId, Boolean enable) throws Exception {
        List<UserCard> cards = cardRepo.findAllByUserIdAndEnable(userId, enable);
        for (UserCard c: cards) {
            c.setCardNumber(HashingConfig.decrypt(c.getCardNumber(), secretKey));
            c.setCvv(HashingConfig.decrypt(c.getCvv(), secretKey));
            String dateString = HashingConfig.decrypt(String.valueOf(c.getExpirationDate()), secretKey);
//            c.setExpirationDate(LocalDate.of()));
        }
        return Mapper.mapAll(cards, UserCardResponseDto.class);
    }

    public List<UserCardResponseDto> getUserCards(Long userId) {
        List<UserCard> cards = cardRepo.findAllByUserId(userId);
        return Mapper.mapAll(cards, UserCardResponseDto.class);
    }

    public UserCardResponseDto addNewCardByUser(UserCardRequestDto userCardRequestDto) throws Exception {
        User user = userRepo.findById(userCardRequestDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        UserCard card = Mapper.map(userCardRequestDto, UserCard.class);
        card.setUser(user);
        card.setCardNumber(HashingConfig.encrypt(userCardRequestDto.getCardNumber(), secretKey));
        card.setCvv(HashingConfig.encrypt(userCardRequestDto.getCvv(), secretKey));
        card.setExpirationDate(LocalDate.parse(HashingConfig.encrypt(String.valueOf(userCardRequestDto.getExpirationDate()), secretKey)));
        return Mapper.map(card, UserCardResponseDto.class);
    }
}

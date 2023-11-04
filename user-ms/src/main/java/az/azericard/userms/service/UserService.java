package az.azericard.userms.service;

import az.azericard.userms.domain.User;
import az.azericard.userms.dto.UserRegistrationRequestDto;
import az.azericard.userms.dto.UserResponseDto;
import az.azericard.userms.repo.UserRepo;
import az.azericard.userms.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepo userRepo;
    public UserResponseDto registerUser(UserRegistrationRequestDto requestDto) {
        User newUser = Mapper.map(requestDto, User.class);
        System.out.println("in service");
        return Mapper.map(userRepo.save(newUser), UserResponseDto.class);
    }
}

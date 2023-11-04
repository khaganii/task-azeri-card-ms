package az.azericard.userms.controller;

import az.azericard.userms.domain.UserCard;
import az.azericard.userms.dto.*;
import az.azericard.userms.security.AuthenticationResponse;
import az.azericard.userms.domain.Transaction;
import az.azericard.userms.service.CardService;
import az.azericard.userms.service.TransactionService;
import az.azericard.userms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CardService cardService;
    private final TransactionService transactionService;

    @PostMapping("/register") //White list item
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRegistrationRequestDto requestDto) {
        return ResponseEntity.ok(userService.registerUser(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        // Implement user login logic, generate a JWT token, and return it in the response.
        return null;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<UserCardResponseDto>> getUserCards(@RequestParam Long userId) {
        return  ResponseEntity.ok(cardService.getUserCards(userId));
    }

    @GetMapping("/cards/enable")
    public ResponseEntity<List<UserCardResponseDto>> getUserCardsByEnable(@RequestParam Long userId, @RequestParam Boolean enable) throws Exception {
        return  ResponseEntity.ok(cardService.getUserCardsByEnable(userId, enable));
    }

    @PostMapping("/cards/add")
    public ResponseEntity<UserCardResponseDto> addUserCard(@RequestBody UserCardRequestDto userCardRequestDto) throws Exception {
        return  ResponseEntity.ok(cardService.addNewCardByUser(userCardRequestDto));
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionDto>> getUserTransactionHistory(@RequestParam Long userId) {
        return ResponseEntity.ok(transactionService.getUserTransactionHistory(userId));
    }

    @PostMapping("/purchase")
    public ResponseEntity<PaymentDto> makePurchase(@RequestBody PurchaseDto purchaseDto) {
        return ResponseEntity.ok(transactionService.makePurchase(purchaseDto));
    }
}

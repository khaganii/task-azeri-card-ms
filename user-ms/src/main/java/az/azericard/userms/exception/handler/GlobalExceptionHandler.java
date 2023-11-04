package az.azericard.userms.exception.handler;

import az.azericard.userms.exception.CardBalanceNotEnoughException;
import az.azericard.userms.exception.ProductCountMoreThanStockException;
import az.azericard.userms.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String errorText = ex.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), errorText);
        return ResponseEntity.badRequest().body(errorMessage);
    }

//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<ErrorMessage> handleUsernameNotFoundException(UsernameNotFoundException ex) {
//        String errorText = ex.getMessage();
//        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), errorText);
//        return ResponseEntity.badRequest().body(errorMessage);
//    }

    @ExceptionHandler(ProductCountMoreThanStockException.class)
    public ResponseEntity<ErrorMessage> handleProductCountMoreThanStockException(ProductCountMoreThanStockException ex) {
        String errorText = ex.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), errorText);
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(CardBalanceNotEnoughException.class)
    public ResponseEntity<ErrorMessage> handleCardBalanceNotEnoughException(CardBalanceNotEnoughException ex) {
        String errorText = ex.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), errorText);
        return ResponseEntity.badRequest().body(errorMessage);
    }
}

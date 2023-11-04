package az.azericard.userms.exception;

public class CardBalanceNotEnoughException extends RuntimeException {

    public CardBalanceNotEnoughException(String message) {
        super(message);
    }
}

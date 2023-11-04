package az.azericard.userms.exception;

public class ProductCountMoreThanStockException extends RuntimeException {

    public ProductCountMoreThanStockException(String message) {
        super(message);
    }
}

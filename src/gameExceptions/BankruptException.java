package src.gameExceptions;

public class BankruptException extends RuntimeException {
    public BankruptException(String message) {
        super(message);
    }
}

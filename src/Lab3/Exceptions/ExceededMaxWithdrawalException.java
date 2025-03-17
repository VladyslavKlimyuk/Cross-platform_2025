package Lab3.Exceptions;

public class ExceededMaxWithdrawalException extends Exception {
    public ExceededMaxWithdrawalException(String message) {
        super(message);
    }
}
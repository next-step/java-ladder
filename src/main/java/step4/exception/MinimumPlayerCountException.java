package step4.exception;

public class MinimumPlayerCountException extends IllegalArgumentException {
    public MinimumPlayerCountException(String message) {
        super(message);
    }
}

package ladder.exception;

public class MinimumPlayerCountException extends IllegalArgumentException {
    public MinimumPlayerCountException(String message) {
        super(message);
    }
}

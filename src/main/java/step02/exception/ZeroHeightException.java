package step02.exception;

public class ZeroHeightException extends IllegalAccessException {
    public ZeroHeightException() {}

    public ZeroHeightException(String message) {
        super(message);
    }
}

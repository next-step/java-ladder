package step4.exception;

public class IllegalPlayerSizeException extends RuntimeException {
    public IllegalPlayerSizeException() {
        super();
    }

    public IllegalPlayerSizeException(String message) {
        super(message);
    }
}

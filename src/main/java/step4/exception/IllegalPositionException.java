package step4.exception;

public class IllegalPositionException extends RuntimeException {
    public IllegalPositionException() {
        super();
    }

    public IllegalPositionException(String message) {
        super(message);
    }
}

package step3.exceptions;

public class OutOfRangePlayerNameException extends RuntimeException {
    public OutOfRangePlayerNameException() {
    }

    public OutOfRangePlayerNameException(String message) {
        super(message);
    }
}

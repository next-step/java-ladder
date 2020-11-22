package step4.exceptions;

public class OutOfRangePositionException extends RuntimeException {
    public OutOfRangePositionException() {
    }

    public OutOfRangePositionException(String message) {
        super(message);
    }
}

package step4.exception;

public class IllegalPositionRangeException extends RuntimeException{

    public IllegalPositionRangeException() {
        super();
    }

    public IllegalPositionRangeException(String message) {
        super(message);
    }
}

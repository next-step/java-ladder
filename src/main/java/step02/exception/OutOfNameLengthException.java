package step02.exception;

public class OutOfNameLengthException extends IllegalAccessException {
    public OutOfNameLengthException() {}

    public OutOfNameLengthException(String message) {
        super(message);
    }
}

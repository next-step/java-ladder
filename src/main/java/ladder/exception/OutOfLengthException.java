package ladder.exception;

public class OutOfLengthException extends RuntimeException {
    public OutOfLengthException() {
        super();
    }

    public OutOfLengthException(String message) {
        super(message);
    }

    public OutOfLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfLengthException(Throwable cause) {
        super(cause);
    }

    protected OutOfLengthException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

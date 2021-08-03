package ladder.exception;

public class InvalidRopeException extends RuntimeException {
    public InvalidRopeException() {
        super();
    }

    public InvalidRopeException(String message) {
        super(message);
    }

    public InvalidRopeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRopeException(Throwable cause) {
        super(cause);
    }

    protected InvalidRopeException(String message, Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

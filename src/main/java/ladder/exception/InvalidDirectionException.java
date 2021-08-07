package ladder.exception;

public class InvalidDirectionException extends RuntimeException {
    public InvalidDirectionException() {
        super();
    }

    public InvalidDirectionException(String message) {
        super(message);
    }

    public InvalidDirectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDirectionException(Throwable cause) {
        super(cause);
    }

    protected InvalidDirectionException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

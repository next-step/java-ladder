package ladder.exception;

public class InvalidPrizeException extends RuntimeException {
    public InvalidPrizeException() {
        super();
    }

    public InvalidPrizeException(String message) {
        super(message);
    }

    public InvalidPrizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPrizeException(Throwable cause) {
        super(cause);
    }

    protected InvalidPrizeException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

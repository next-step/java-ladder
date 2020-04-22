package ladder.view.exception;

public class InvalidNamesInputException extends RuntimeException {
    public InvalidNamesInputException() {
    }

    public InvalidNamesInputException(String message) {
        super(message);
    }

    public InvalidNamesInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNamesInputException(Throwable cause) {
        super(cause);
    }

    public InvalidNamesInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

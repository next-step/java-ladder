package ladder.view.exception;

public class InvalidLadderHeightException extends RuntimeException {
    public InvalidLadderHeightException() {
    }

    public InvalidLadderHeightException(String message) {
        super(message);
    }

    public InvalidLadderHeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLadderHeightException(Throwable cause) {
        super(cause);
    }

    public InvalidLadderHeightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

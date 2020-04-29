package ladder.view.exception;

public class InvalidLadderResultInputException extends RuntimeException{
    public InvalidLadderResultInputException() {
    }

    public InvalidLadderResultInputException(String message) {
        super(message);
    }

    public InvalidLadderResultInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLadderResultInputException(Throwable cause) {
        super(cause);
    }

    public InvalidLadderResultInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

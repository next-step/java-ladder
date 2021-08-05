package ladder.exception;

public class OutOfLengthException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "유효한 문자열의 길이가 아닙니다.";
    public OutOfLengthException() {
        super(DEFAULT_MESSAGE);
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

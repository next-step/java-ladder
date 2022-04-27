package ladder.exception;

public class InvalidLineException extends RuntimeException {

    private static final String INVALID_LINE_MESSAGE = "올바르지 않은 라인입니다";

    public InvalidLineException() {
        super(INVALID_LINE_MESSAGE);
    }

}

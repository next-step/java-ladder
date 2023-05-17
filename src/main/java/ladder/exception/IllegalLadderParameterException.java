package ladder.exception;

public class IllegalLadderParameterException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "높이는 0 이상, 너비는 2 이상이 되어야 합니다.";

    public IllegalLadderParameterException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}

package ladder.exception;

public class ContinuousHorizontalLineException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "동일한 높이에서 연속되는 가로선이 있습니다.";

    public ContinuousHorizontalLineException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}

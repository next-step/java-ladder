package ladder.exception;

public class IllegalVerticalLineWidthException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "최대 너비를 초과하는 세로선이 있습니다.";

    public IllegalVerticalLineWidthException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}

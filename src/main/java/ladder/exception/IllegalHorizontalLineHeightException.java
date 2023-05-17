package ladder.exception;

public class IllegalHorizontalLineHeightException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "최대 높이를 초과하는 가로선이 있습니다.";

    public IllegalHorizontalLineHeightException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}

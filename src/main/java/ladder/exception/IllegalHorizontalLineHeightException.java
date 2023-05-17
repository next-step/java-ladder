package ladder.exception;

public class IllegalHorizontalLineHeightException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "적절하지 않은 높이의 가로선입니다.";

    public IllegalHorizontalLineHeightException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}

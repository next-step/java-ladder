package ladder.exception;

public class NotEnoughVerticalLinesException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "최소 두 개 이상의 세로선이 있어야 합니다.";

    public NotEnoughVerticalLinesException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}

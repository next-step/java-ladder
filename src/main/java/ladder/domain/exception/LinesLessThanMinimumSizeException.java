package ladder.domain.exception;

public class LinesLessThanMinimumSizeException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "최소 라인들 사이즈보다 작습니다. 최소 사이즈 : %s";

    public LinesLessThanMinimumSizeException(String message) {
        super(message);
    }

    public static LinesLessThanMinimumSizeException from(int minimumLinesSize) {
        return new LinesLessThanMinimumSizeException(String.format(MESSAGE_FORMAT, minimumLinesSize));
    }
}

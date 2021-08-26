package ladder.exception;

public class LadderHeightException extends RuntimeException {
    private static final String LADDER_MIN_HEIGHT_EXCEPTION_COMMENT = "사다리의 높이는 %d이상이어야 합니다.";

    public LadderHeightException(int height) {
        super(String.format(LADDER_MIN_HEIGHT_EXCEPTION_COMMENT, height));
    }
}

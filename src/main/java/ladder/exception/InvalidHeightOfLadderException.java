package ladder.exception;

public class InvalidHeightOfLadderException extends RuntimeException {

    private static final String INVALID_HEIGHT_OF_LADDER_EXCEPTION_MESSAGE = "사다리 높이는 1 이상이어야 합니다.";

    public InvalidHeightOfLadderException() {
        super(INVALID_HEIGHT_OF_LADDER_EXCEPTION_MESSAGE);
    }
}

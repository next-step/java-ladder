package laddergame.exception;

public class InvalidHeightOfLadderException extends IllegalArgumentException {
    private static final String WRONG_LADDER_HEIGHT_MESSAGE = "(%s): 잘못된 사다리 높이입니다.";

    public InvalidHeightOfLadderException(int wrongInput) {
        super(String.format(WRONG_LADDER_HEIGHT_MESSAGE, wrongInput));
    }
}

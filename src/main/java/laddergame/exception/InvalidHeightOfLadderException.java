package laddergame.exception;

import static laddergame.domain.HeightOfLadder.LADDER_MIN_HEIGHT;

public class InvalidHeightOfLadderException extends IllegalArgumentException {
    private static final String WRONG_LADDER_HEIGHT_MESSAGE = "(%s): 사다리 높이는 %d 이상의 양의 정수이어야 합니다.";

    public InvalidHeightOfLadderException(int wrongInput) {
        super(String.valueOf(wrongInput));
    }

    public InvalidHeightOfLadderException(String wrongInput) {
        super(String.format(WRONG_LADDER_HEIGHT_MESSAGE, wrongInput, LADDER_MIN_HEIGHT));
    }
}

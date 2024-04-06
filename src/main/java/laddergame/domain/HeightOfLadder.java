package laddergame.domain;

import static laddergame.exception.ExceptionMessage.WRONG_LADDER_HEIGHT_MESSAGE;

public class HeightOfLadder {
    public static final int LADDER_MIN_HEIGHT = 1;

    private final int height;

    public HeightOfLadder(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < LADDER_MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format(WRONG_LADDER_HEIGHT_MESSAGE.message(), height, LADDER_MIN_HEIGHT));
        }
    }

    public int height() {
        return height;
    }
}

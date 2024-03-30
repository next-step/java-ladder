package laddergame.domain;

import laddergame.exception.InvalidHeightOfLadderException;

import static laddergame.util.Validator.isGreaterThanOrEqualStandard;

public class HeightOfLadder {
    public static final int LADDER_MIN_HEIGHT = 1;

    private final int height;

    private HeightOfLadder(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (!isGreaterThanOrEqualStandard(height, LADDER_MIN_HEIGHT)) {
            throw new InvalidHeightOfLadderException(height);
        }
    }

    public static HeightOfLadder valueOf(int height) {
        return new HeightOfLadder(height);
    }

    public int height() {
        return height;
    }
}

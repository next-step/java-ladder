package nextstep.ladder;

import nextstep.ladder.exception.IllegalLadderHeightException;

public class LadderHeight {

    private static final int MIN_HEIGHT_COUNT = 0;

    private final int height;

    private LadderHeight(int height) {
        validate(height);
        this.height = height;
    }

    public static LadderHeight of(int height) {
        return new LadderHeight(height);
    }

    private void validate(int height) {
        if (height <= MIN_HEIGHT_COUNT) {
            throw new IllegalLadderHeightException(height);
        }
    }
}

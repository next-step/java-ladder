package ladder.model;

import ladder.exception.LadderHeightOutOfRangeException;

public class LadderHeight {

    private static final int ZERO = 0;

    private int height;

    private LadderHeight(final int height) {
        if (height <= ZERO) {
            throw new LadderHeightOutOfRangeException();
        }

        this.height = height;
    }

    public static LadderHeight create(final int height) {
        return new LadderHeight(height);
    }

    public int getHeight() {
        return height;
    }
}

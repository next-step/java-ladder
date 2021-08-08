package nextstep.ladder.ladder;

import nextstep.ladder.exception.IllegalLadderHeightException;

public class LadderBound {

    private static final int MIN_HEIGHT_COUNT = 0;

    private final int width;
    private final int height;

    private LadderBound(int width, int height) {
        validate(height);
        this.width = width;
        this.height = height;
    }

    public static LadderBound of(int width, int height) {
        return new LadderBound(width, height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private void validate(int height) {
        if (height <= MIN_HEIGHT_COUNT) {
            throw new IllegalLadderHeightException(height);
        }
    }
}

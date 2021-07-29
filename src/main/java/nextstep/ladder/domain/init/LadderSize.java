package nextstep.ladder.domain.init;

import nextstep.ladder.exception.OutOfRangeArgumentException;

public class LadderSize {
    protected static final int MINIMUM_LENGTH = 1;

    private final int width;
    private final int height;

    public LadderSize(int width, int height) {
        validate(width, height);

        this.width = width;
        this.height = height;
    }

    private void validate(int width, int height) {
        if (width < MINIMUM_LENGTH) {
            throw OutOfRangeArgumentException.greaterThanOrEqualTo(MINIMUM_LENGTH, width);
        }

        if (height < MINIMUM_LENGTH) {
            throw OutOfRangeArgumentException.greaterThanOrEqualTo(MINIMUM_LENGTH, height);
        }
    }

    public static LadderSize of(int width, int height) {
        return new LadderSize(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isEqualToWidth(int size) {
        return width == size;
    }
}

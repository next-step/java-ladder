package step3.ladderGame.domain.ladder;

import step3.ladderGame.domain.exception.HeightLowException;

public final class Height {

    private static final int MIN_LENGTH_BY_HEIGHT = 1;

    private final int height;

    public Height(final int height) {
        validate(height);
        this.height = height;
    }

    private void validate(final int height) {
        if (height < MIN_LENGTH_BY_HEIGHT) {
            throw new HeightLowException();
        }
    }

    public int getValue() {
        return this.height;
    }

}

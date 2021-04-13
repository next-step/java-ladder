package ladder.domain;

import ladder.exception.InputNegativeNumberException;

public final class LadderHeight {

    public static final int ZERO = 0;

    private final int height;

    public LadderHeight(int height) {
        validateNegative(height);
        this.height = height;
    }

    private final void validateNegative(int height) {
        if (height < ZERO) {
            throw new InputNegativeNumberException();
        }
    }

    public static final LadderHeight valueOf(int height) {
        return new LadderHeight(height);
    }

    public final int toInt() {
        return height;
    }
}

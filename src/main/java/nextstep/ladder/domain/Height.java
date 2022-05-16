package nextstep.ladder.domain;

import nextstep.ladder.exception.HeightLessThanStandardException;

public class Height {
    private static final int LADDER_HEIGHT_MINIMUM_BOUNDARY = 1;

    private final int value;

    public Height(int value) {
        validateBoundary(value);
        this.value = value;
    }

    private void validateBoundary(int height) {
        if (height < LADDER_HEIGHT_MINIMUM_BOUNDARY) {
            throw new HeightLessThanStandardException(height);
        }
    }

    public int getValue() {
        return value;
    }
}

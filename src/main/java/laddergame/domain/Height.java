package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Objects;

public class Height {
    public static final int MINIMUM_OF_HEIGHT = 1;

    private final Count height;

    public Height(int height) {
        validateOverMinimum(height);
        this.height = new Count(height);
    }

    private void validateOverMinimum(int height) {
        if (height < MINIMUM_OF_HEIGHT) {
            throw new LadderGameException(ErrorCode.HEIGHT_UNDER_MINIMUM);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    public boolean bigger(Count count) {
        return this.height.bigger(count);
    }
}

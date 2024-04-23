package ladder.domain.ladder;

import java.util.Objects;

public class Width {

    public static final int MINIMUM_WIDTH = 1;

    private final int value;

    public Width(final int value) {
        validateWidthIsNotLessThanMinimum(value);

        this.value = value;
    }

    private void validateWidthIsNotLessThanMinimum(final int value) {
        if (value < MINIMUM_WIDTH) {
            throw new IllegalArgumentException("사다리 너비는 최소 너비 이상이어야 합니다. 개수: " + value);
        }
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(final Object otherWidth) {
        if (this == otherWidth) {
            return true;
        }

        if (otherWidth == null || getClass() != otherWidth.getClass()) {
            return false;
        }

        return this.value == ((Width)otherWidth).value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}

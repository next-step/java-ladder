package ladder.domain.ladder;

import java.util.Objects;

public class Height {

    public static final int MINIMUM_HEIGHT = 1;

    private final int value;

    public Height(final int value) {
        validateHeightIsNotLessThanMinimum(value);

        this.value = value;
    }

    private void validateHeightIsNotLessThanMinimum(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리는 최소 높이보다 작을 수 없습니다. 높이: " + height);
        }
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(final Object otherHeight) {
        if (this == otherHeight) {
            return true;
        }

        if (otherHeight == null || getClass() != otherHeight.getClass()) {
            return false;
        }

        return this.value == ((Height)otherHeight).value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}

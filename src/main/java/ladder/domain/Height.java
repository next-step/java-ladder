package ladder.domain;

import ladder.exception.HeightOutOfBoundException;
import ladder.exception.InvalidHeightException;

import java.util.Objects;

public class Height {
    public static final int MIN_HEIGHT = 1;

    private final int value;

    private Height(final int value) {
        isLessThanMinHeight(value);
        this.value = value;
    }

    public static Height of(final String value) {
        validHeight(value);
        return new Height(Integer.valueOf(value));
    }

    int value() {
        return value;
    }

    private static void validHeight(final String height) {
        if (Objects.isNull(height) || height.trim().isEmpty()) {
            throw new InvalidHeightException(height);
        }
    }

    private void isLessThanMinHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new HeightOutOfBoundException(height);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

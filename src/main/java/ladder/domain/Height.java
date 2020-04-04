package ladder.domain;

import ladder.exception.InvalidHeightException;

import java.util.Objects;

public class Height {
    private int value;

    private Height(final int value) {
        this.value = value;
    }

    public static Height of(final String value) {
        validHeight(value);
        return new Height(Integer.valueOf(value));
    }

    private static void validHeight(final String height) {
        if (Objects.isNull(height) || height.trim().isEmpty()) {
            throw new InvalidHeightException(height);
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

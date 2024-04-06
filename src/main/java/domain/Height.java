package domain;

import java.util.Objects;

public class Height {

    private static final int MIN_HEIGHT = 0;

    private final int value;

    public Height(int value) {
        validateGreaterThenMinHeight(value);
        this.value = value;
    }

    private static void validateGreaterThenMinHeight(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 0보다 커야합니다.");
        }
    }

    public int getHeight() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

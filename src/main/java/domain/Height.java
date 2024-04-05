package domain;

import java.util.Objects;

public class Height {

    private static final int MIN_HEIGHT = 1;

    private final int value;

    public Height(int value) {
        assertGreaterThenMinHeight(value);
        this.value = value;
    }

    private static void assertGreaterThenMinHeight(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1보다 커야합니다.");
        }
    }

    public int height() {
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

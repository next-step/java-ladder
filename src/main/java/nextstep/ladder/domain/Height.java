package nextstep.ladder.domain;

import java.util.Objects;

public class Height {
    private static final int ZERO = 0;

    private final int height;

    private Height(final int height) {
        this.height = height;
    }

    public static Height of(final int height) {
        if (height <= ZERO) {
            throw new IllegalArgumentException("invalid height: must larger than 0, but " + height);
        }

        return new Height(height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return this.height == height.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    public int toInt() {
        return height;
    }
}

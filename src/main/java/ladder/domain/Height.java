package ladder.domain;

import java.util.Objects;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int height;

    private Height(final int height) {
        this.height = height;
    }

    public static Height from(final int height) {
        if (height < MIN_HEIGHT) {
            throw new RuntimeException("사다리 높이는 최소 1이상이어야 합니다.");
        }
        return new Height(height);
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
}

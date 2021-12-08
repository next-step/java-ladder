package step4.domain;

import java.util.Objects;

public class Height {
    private static final int MIN_HEIGHT = 0;

    private final int height;

    private Height(int height) {
        validate(height);
        this.height = height;
    }

    public static Height of(int height) {
        return new Height(height);
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("유효하지 않는 높이이 값 니다.");
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
}

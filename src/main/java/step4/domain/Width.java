package step4.domain;

import java.util.Objects;

public class Width {
    private static final int MIN_WIDTH = 0;

    private final int width;

    private Width(int width) {
        validate(width);
        this.width = width;
    }

    public static Width of(int width) {
        return new Width(width);
    }

    public int width() {
        return width;
    }

    private void validate(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("유효하지 않는 너비 값 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Width width1 = (Width) o;
        return width == width1.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}

package step2.domain;

import java.util.Objects;

public class Width {
    private final int width;

    private Width(int width) {
        this.width = width;
    }

    public static Width of(int width) {
        return new Width(width);
    }

    public int getWidth() {
        return width;
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

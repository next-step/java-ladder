package step2.domain;

import java.util.Objects;

public class Height {
    private int height;

    private Height() {
    }

    private Height(int height) {
        this.height = height;
    }

    public static Height of(int height) {
        return new Height(height);
    }

    public static Height of(String height) {
        return new Height(Integer.parseInt(height));
    }

    public int getHeight() {
        return height;
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

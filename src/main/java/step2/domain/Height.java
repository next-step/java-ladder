package step2.domain;

import java.util.Objects;

public class Height {
    public static final int MIN_NUMBER = 0;

    private final int height;

    private Height(int height) {
        validate(height);
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

    private static void validate(int height) {
        if (height < MIN_NUMBER) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
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

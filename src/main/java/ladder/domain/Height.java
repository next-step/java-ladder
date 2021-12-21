package ladder.domain;

import java.util.Objects;

public class Height {
    private static final int MIN = 2;

    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height of(int height) {
        if (height < MIN) {
            throw new IllegalArgumentException("높이는 2 이상부터 가능합니다.");
        }

        return new Height(height);
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

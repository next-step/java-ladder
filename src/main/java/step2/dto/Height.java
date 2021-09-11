package step2.dto;

import java.util.Objects;

public class Height {
    private static final int MIN_LIMIT = 0;

    private final int height;

    public Height(int height) {
        if (height < MIN_LIMIT) {
            throw new RuntimeException(String.format("사다리 높이는 %d 보다 작을 수 없습니다", MIN_LIMIT));
        }
        this.height = height;
    }

    public int height() {
        return this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public String toString() {
        return "Height{" +
                "height=" + height +
                '}';
    }
}

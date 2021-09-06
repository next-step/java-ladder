package laddergame.ladder;

import java.util.Objects;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height (int height) {
        isValid(height);
        this.height = height;
    }

    private void isValid(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 1입니다.");
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

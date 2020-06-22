package laddergame.domain.vo;

import java.util.Objects;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(final int height) {
        validateHeight(height);
        this.height = height;
    }

    public int toInt() {
        return height;
    }

    private void validateHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다. - " + height);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        Height height1 = (Height) o;
        return toInt() == height1.toInt();
    }

    @Override
    public int hashCode() {
        return Objects.hash(toInt());
    }
}

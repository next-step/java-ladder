package step3.domain;

import java.util.Objects;

public class Height {
    public static final int MINIMUM_HEIGHT = 2;
    private static final String MINIMUM_HEIGHT_ERROR = "사다리의 높이는 최소 2 이상이어야 합니다.";
    private final int height;

    public Height(int height) {
        checkMinimumHeight(height);
        this.height = height;
    }

    public int height() {
        return height;
    }

    private void checkMinimumHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(MINIMUM_HEIGHT_ERROR);
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

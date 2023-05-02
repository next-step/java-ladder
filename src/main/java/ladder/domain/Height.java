package ladder.domain;

import java.util.Objects;

public class Height {
    private final int MIN_HEIGHT = 1;
    private final int MAX_HEIGHT = 30;
    private final int height;

    public Height(int height) {
        if (!isHeightInRange(height)) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT + "이상 " + MAX_HEIGHT + "이하만 가능합니다.");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private boolean isHeightInRange(int height) {
        return height >= MIN_HEIGHT && height <= MAX_HEIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}

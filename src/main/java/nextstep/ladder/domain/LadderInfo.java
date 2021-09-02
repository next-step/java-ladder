package nextstep.ladder.domain;

import java.util.Objects;

public class LadderInfo {
    private final int width;
    private final int height;

    public LadderInfo(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isRightLadderInfo(int minValue) {
        return width >= minValue && height >= minValue;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "입력된 사다리 정보{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderInfo that = (LadderInfo) o;
        return width == that.width &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

}

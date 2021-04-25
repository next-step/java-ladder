/*
* 사다리의 가로와 높이를 담당하는 원시값 포장 클래스
* */
package step4.laddergame.domain.ladder;

import java.util.Objects;

public class Size {
    private static final String ILLEGAL_SIZE = "높이와 너비는 0~10 사이여야합니다.";
    private static final int MAXIMUM_SIZE = 10;

    private final int height;
    private final int width;

    public Size(int height, int width) {
        validSize(height);
        validSize(width);
        this.height = height;
        this.width = width;
    }

    public static Size of(int height, int width) {
        return new Size(height, width);
    }

    private void validSize(int size) {
        if (size > MAXIMUM_SIZE || size < 0) {
            throw new IllegalArgumentException(ILLEGAL_SIZE);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size height1 = (Size) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}

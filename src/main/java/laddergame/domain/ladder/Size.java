/*
* 사다리의 가로와 높이를 담당하는 원시값 포장 클래스
* */
package laddergame.domain.ladder;

import java.util.Objects;
import java.util.stream.IntStream;

import static laddergame.util.Message.ILLEGAL_HEIGHT;

public class Size {
    private static final int MAXIMUM_HEIGHT = 10;

    private final int height;
    private final int width;

    public Size(int height, int width) {
        validHeight(height);
        this.height = height;
        this.width = width;
    }

    private void validHeight(int height) {
        if (height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(ILLEGAL_HEIGHT);
        }
    }

    public IntStream heightRange() {
        return IntStream.range(0, height);
    }

    public IntStream widthRange() {
        return IntStream.range(0, width);
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

package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private final int index;

    public Point(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("음수 지점은 불가능합니다.");
        }
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return index == point.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}

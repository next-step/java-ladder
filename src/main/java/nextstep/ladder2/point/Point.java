package nextstep.ladder2.point;

import nextstep.ladder2.ErrorMessage;

import java.util.Objects;

public class Point {
    public static final Point INVALID_POINT = new Point(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
    private final int maxIndex;
    private final int minIndex = 0;
    private int index;

    public Point(int index, int maxIndex) {
        this.maxIndex = maxIndex;
        validation(index);
        this.index = index;
    }

    private void validation(int index) {
        if (index < 0 || index > maxIndex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INDEX.message());
        }
    }

    public int index() {
        return index;
    }

    public Point right() {
        if (index < maxIndex) {
            return new Point(index + 1, maxIndex);
        }
        return INVALID_POINT;
    }

    public Point left() {
        if (index > 0) {
            return new Point(index - 1, maxIndex);
        }
        return INVALID_POINT;
    }

    public final int MAX_INDEX(){
        return maxIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                '}';
    }
}

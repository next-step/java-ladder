package ladder.domain;

import ladder.exception.PointException;

import java.util.Objects;

public class Point {
    public static final String NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE = "사다리 라인을 연속해서 만들 수 없습니다.";
    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        if (left && current) {
            throw new PointException(NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE);
        }
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public boolean getCurrent() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }
}
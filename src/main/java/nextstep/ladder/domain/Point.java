package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean previous;
    private final boolean current;

    public Point(boolean previous, boolean current) {
        validation(previous, current);
        this.previous = previous;
        this.current = current;
    }

    private void validation(boolean previous, boolean current) {
        if (previous && current) {
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
        }
    }

    public boolean current() {
        return current;
    }

    public Direction nextDirection() {
        if (previous) {
            return Direction.LEFT;
        }

        if (current) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public static Point last(boolean previous) {
        return new Point(previous, false);
    }

    public Point next(boolean nextCurrent) {
        if (current) {
            return new Point(true, false);
        }
        return new Point(false, nextCurrent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return previous == point.previous && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(previous, current);
    }

    @Override
    public String toString() {
        return "Point{" +
                "previous=" + previous +
                ", current=" + current +
                '}';
    }
}

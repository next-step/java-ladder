package ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean current;

    public static Point first(boolean current) {

        return new Point(false, current);
    }

    private Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public Point next(boolean current) {
        if (this.current) {
            current = false;
        }
        return new Point(this.current, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Direction movedDirection() {
        if (!left && current) {
            return Direction.RIGHT;
        }
        if (left && !current) {
            return Direction.LEFT;
        }

        return Direction.PASS;
    }

    public boolean isDraw() {
        if (left == true && current == false) {
            return true;
        }
        return false;
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


}

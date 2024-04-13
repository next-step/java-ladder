package ladder.domain.ladders.ladder;

import ladder.domain.participants.Position;

import java.util.Objects;

public class Point {

    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        if (left && current) {
            current = false;
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

    public Position move(Position position) {
        if (this.left) {
            return Direction.LEFT.move(position);
        }

        if (this.current) {
            return Direction.RIGHT.move(position);
        }

        return Direction.BYPASS.move(position);
    }

    public boolean isLeft() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}

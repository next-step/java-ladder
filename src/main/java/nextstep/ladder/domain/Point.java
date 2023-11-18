package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private final boolean left;
    private final boolean current;

    public Point(boolean left,
                 boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Point first(Boolean mayBeDraw) {
        return new Point(false, mayBeDraw);
    }

    public Point draw(Boolean mayBeDraw) {
        return new Point(this.current, mayBeDraw);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Direction move() {
        if (current) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.STAY;
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

package nextstep.ladder.v2.model;

import java.util.Objects;

public class Point {
    private boolean previous;
    private boolean current;

    public Point(boolean previous, boolean current) {
        this.previous = previous;
        this.current = current;
    }

    public static Point first(PointGenerator pointGenerator) {
        return new Point(false, pointGenerator.generate(false));
    }

    public static Point first(boolean cur) {
        return new Point(false, cur);
    }

    public boolean isCurrent() {
        return current;
    }

    public Direction getDirection() {
        return Direction.of(this.previous, this.current);
    }

    public int getNextPosition(int startPosition) {
        return getDirection().getNextPosition(startPosition);
    }

    public Point next(PointGenerator pointGenerator) {
        return new Point(this.current, pointGenerator.generate(this.current));
    }

    public Point last() {
        return new Point(this.current, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return getDirection() == point.getDirection();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDirection());
    }
}
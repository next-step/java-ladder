package nextstep.ladder.v2.model;

import java.util.Objects;

public class Point {
    private boolean prev;
    private boolean cur;
    private Direction direction;

    public Point(boolean prev, boolean cur) {
        this.prev = prev;
        this.cur = cur;
        this.direction = Direction.of(this.prev, this.cur);
    }

    public static Point first(PointGenerator pointGenerator) {
        return new Point(false, pointGenerator.generate(false));
    }

    public static Point first(boolean cur) {
        return new Point(false, cur);
    }

    public boolean isCur() {
        return cur;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Point next(PointGenerator pointGenerator) {
        return new Point(this.cur, pointGenerator.generate(this.cur));
    }

    public Point last() {
        return new Point(this.cur, false);
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
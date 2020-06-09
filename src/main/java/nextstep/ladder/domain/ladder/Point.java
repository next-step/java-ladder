package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(boolean currentStatus) {
        this(0, new Direction(currentStatus, false));
    }

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public boolean getValue() {
        return this.direction.getCurrentStatus();
    }

    public int move() {
        return this.index + HorizontalMoveStrategy.findByDirection(this.direction);
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
        return Objects.hash(index, direction);
    }
}

package nextstep.ladder.domain.ladder;

import java.util.Objects;

import static nextstep.ladder.domain.ladder.Direction.*;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Direction currentDirection() {
        return direction;
    }

    public static Point createPoint(boolean isLastPoint,
                                       DirectionPredicate predicate,
                                       Point prePoint) {
        if (isLastPoint) {
            return prePoint.last();
        }
        return prePoint.next(predicate);
    }

    public Point next(DirectionPredicate predicate) {
        Direction direction = (this.direction == RIGHT) ? LEFT : generate(predicate);
        return new Point(direction);
    }

    public Point last() {
        Direction direction = (this.direction == RIGHT) ? LEFT : DOWN;
        return new Point(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}

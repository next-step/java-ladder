package nextstep.ladder.domain.generator;

import nextstep.ladder.domain.Direction;

import java.util.Objects;

public class Point {
    private final static int FIRST_POSITION = 0;
    private final static int NEXT_INCREASE_VALUE = 1;

    private final Direction direction;
    private final int position;

    protected Point(Direction direction, int position) {
        this.direction = direction;
        this.position = position;
    }

    public Direction direction() {
        return direction;
    }

    public int position() {
        return position;
    }

    public static Point first(boolean current) {
        return new Point(createDirection(current), FIRST_POSITION);
    }

    public static Point last(Point previousPoint) {
        if (Direction.RIGHT.equals(previousPoint.direction())) {
            return new Point(Direction.LEFT, previousPoint.position() + NEXT_INCREASE_VALUE);
        }
        return new Point(Direction.DOWN, previousPoint.position() + NEXT_INCREASE_VALUE);
    }

    public Point next(boolean next) {
        if (Direction.RIGHT.equals(this.direction)) {
            return new Point(Direction.LEFT, position + NEXT_INCREASE_VALUE);
        }
        return new Point(createDirection(next), position + NEXT_INCREASE_VALUE);
    }

    public static Direction createDirection(boolean current) {
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, position);
    }

    @Override
    public String toString() {
        return "Point{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }
}

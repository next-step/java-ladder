package ladder.domain.ladder;

import ladder.strategy.LineGenerateStrategy;
import ladder.exception.DirectionNullPointerException;
import ladder.exception.InputNegativeNumberException;

import java.util.Objects;

public final class Point {

    private static final int ZERO = 0;
    private static final int INCREASE = 1;

    private final int position;
    private final Direction direction;

    private Point(final int position, final Direction direction) {
        validateNegative(position);
        validateNull(direction);
        this.position = position;
        this.direction = direction;
    }

    private final void validateNull(final Direction direction) {
        if (Objects.isNull(direction)) {
            throw new DirectionNullPointerException();
        }
    }

    private final void validateNegative(final int position) {
        if (position < ZERO) {
            throw new InputNegativeNumberException(position);
        }
    }

    public final int move() {
        Heading heading = direction.heading();
        return heading.move(position);
    }

    public static final Point first(final boolean right) {
        return new Point(ZERO, Direction.first(right));
    }

    public final Point last() {
        return new Point(position + INCREASE, direction.last());
    }

    public final Point next(LineGenerateStrategy strategy) {
        return new Point(position + INCREASE, direction.next(strategy));
    }

    public final boolean isLeft() {
        return direction.heading().equals(Heading.LEFT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }


}

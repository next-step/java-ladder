package ladder.domain.ladder;

import ladder.domain.strategy.LineGenerateStrategy;
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
        Heading heading = direction.move();
        return heading.go(position);
    }

    public static final Point first(final boolean current) {
        return new Point(ZERO, Direction.first(current));
    }

    public final Point last() {
        return new Point(position + INCREASE, direction.last());
    }

    public final Point next(LineGenerateStrategy strategy) {
        return new Point(position + INCREASE, direction.next(strategy));
    }

    public final Point next(final boolean current) {
        return new Point(position + INCREASE, direction.next(current));
    }


}

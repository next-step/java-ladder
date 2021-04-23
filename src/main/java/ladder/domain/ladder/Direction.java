package ladder.domain.ladder;

import ladder.strategy.LineGenerateStrategy;
import ladder.exception.IllegalBooleanArgumentsException;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public final class Direction {

    private final boolean left;
    private final boolean current;

    private Direction(final boolean left, final boolean current) {
        validateArguments(left, current);
        this.left = left;
        this.current = current;
    }

    private final void validateArguments(final boolean left, final boolean current) {
        if (left && current) {
            throw new IllegalBooleanArgumentsException(left, current);
        }
    }

    public static final Direction first(final boolean current) {
        return new Direction(FALSE, current);
    }

    public final Heading move() {
        return Heading.valueOf(left, current);
    }

    private final Direction next(final boolean current) {
        return new Direction(this.current, current);
    }

    public final Direction last() {
        return new Direction(this.current, FALSE);
    }

    public final Direction next(LineGenerateStrategy strategy) {
        if (this.current) {
            return next(FALSE);
        }
        return next(strategy.generate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}

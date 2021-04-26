package ladder.domain.ladder;

import ladder.strategy.LineGenerateStrategy;
import ladder.exception.IllegalBooleanArgumentsException;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public final class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        validateArguments(left, right);
        this.left = left;
        this.right = right;
    }

    private final void validateArguments(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalBooleanArgumentsException(left, right);
        }
    }

    public static final Direction first(final boolean right) {
        return new Direction(FALSE, right);
    }

    public final Heading heading() {
        if (this.left) {
            return Heading.LEFT;
        }
        if (this.right) {
            return Heading.RIGHT;
        }
        return Heading.PASS;
    }

    private final Direction next(final boolean right) {
        return new Direction(this.right, right);
    }

    public final Direction last() {
        return new Direction(this.right, FALSE);
    }

    public final Direction next(LineGenerateStrategy strategy) {
        if (this.right) {
            return next(FALSE);
        }
        return next(strategy.generate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

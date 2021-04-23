package ladder.domain.ladder;

import ladder.domain.strategy.LineGenerateStrategy;
import ladder.exception.IllegalBooleanArgumentsException;

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
}

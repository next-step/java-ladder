package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {

    public static final int DISTANCE = 1;

    private final boolean hasLeftLine;
    private final boolean hasRightLine;

    private Direction(boolean hasLeftLine, boolean hasRightLine) {
        this.hasLeftLine = hasLeftLine;
        this.hasRightLine = hasRightLine;
    }

    public Direction next(boolean nextRight) {
        return of(this.hasRightLine, nextRight);
    }

    public Direction next(LineStrategy lineStrategy) {
        if (this.hasRightLine) {
            return next(FALSE);
        }
        return next(lineStrategy.hasLine());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.hasRightLine, FALSE);
    }

    public int getNextIndex(int index) {
        if (hasLeftLine) {
            return index - DISTANCE;
        }
        if (hasRightLine) {
            return index + DISTANCE;
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return hasLeftLine == direction.hasLeftLine &&
                hasRightLine == direction.hasRightLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasLeftLine, hasRightLine);
    }
}

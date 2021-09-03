package step4.ladderGame.domain.ladder;

import step4.ladderGame.domain.exception.HaveSeveralDirectionsException;
import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateDirectionStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public final class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new HaveSeveralDirectionsException();
        }

        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public Direction next(final boolean nextRight) {
        return of(right, nextRight);
    }

    public Direction next(final GenerateDirectionStrategy generateDirectionStrategy) {
        return next(generateDirectionStrategy.generateDirection(right));
    }

    public static Direction of(final boolean first, final boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(final GenerateDirectionStrategy generateDirectionStrategy) {
        return of(FALSE, generateDirectionStrategy.generateDirection());
    }

    public Direction last() {
        return of(right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}

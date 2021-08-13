package nextstep.ladder.domain.common;

import java.util.Objects;
import nextstep.ladder.domain.common.exception.InvalidCreateDirectionException;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new InvalidCreateDirectionException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction of(final boolean first, final boolean second) {
        return new Direction(first, second);
    }

    public static Direction first() {
        final DirectionGenerator generator = new RightDirectionGenerator();
        return of(false, generator.generate(false));
    }

    public Direction next() {
        final DirectionGenerator generator = new RightDirectionGenerator();
        return of(this.right, generator.generate(this.right));
    }

    public Direction last() {
        return of(this.right, false);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isPossibleNext(final Direction next) {
        return this.right == next.left;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Direction)) {
            return false;
        }
        final Direction direction = (Direction) o;
        return isLeft() == direction.isLeft() && isRight() == direction.isRight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLeft(), isRight());
    }
}

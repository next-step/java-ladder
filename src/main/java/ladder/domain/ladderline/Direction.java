package ladder.domain.ladderline;

import ladder.common.RandomStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("Wrong direction");
        }
    }

    private static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    static Direction ofStart(RandomStrategy randomStrategy) {
        return of(FALSE, randomStrategy.get());
    }

    Direction ofEnd() {
        return of(this.right, FALSE);
    }

    Direction next(RandomStrategy randomStrategy) {
        if (this.right) {
            return of(this.right, FALSE);
        }
        return of(this.right, randomStrategy.get());
    }

    boolean isLeft() {
        return left;
    }

    boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

package ladder.domain;

import ladder.strategy.GeneratorStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        checkValidation(left, right);
        this.left = left;
        this.right = right;
    }

    private void checkValidation(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("왼쪽과 오른쪽, 둘 다는 없다.");
        }
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(final boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(final GeneratorStrategy movingStrategy) {
        return next(movingStrategy.generatePoint(this.right));
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(GeneratorStrategy generatorStrategy) {
        return of(FALSE, generatorStrategy.generatePoint(false));
    }

    public Direction last() {
        return of(this.right, FALSE);
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

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

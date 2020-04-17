package ladder.ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new InvalidDirectionException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction generateFirst(boolean right) {
        return of(FALSE, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public Direction generateNext(LinkStrategy linkStrategy) {
        if (isRight()) {
            return of(right, FALSE);
        }
        return of(right, linkStrategy.get());
    }

    public Direction generateNext(boolean nextRight) {
        if (isRight()) {
            return of(TRUE, FALSE);
        }
        return of(right, nextRight);
    }

    public Direction generateLast() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return isLeft() == direction.isLeft() &&
                isRight() == direction.isRight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLeft(), isRight());
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

}

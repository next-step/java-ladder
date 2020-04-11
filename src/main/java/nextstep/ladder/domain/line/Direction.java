package nextstep.ladder.domain.line;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction getNext(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction getNext(DirectionSelector directionSelector) {
        if (this.right) {
            return getNext(FALSE);
        }
        return getNext(directionSelector.hasRightDirection());
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction getFirst(DirectionSelector directionSelector) {
        return of(FALSE, directionSelector.hasRightDirection());
    }

    public static Direction getFirst(boolean right) {
        return of(FALSE, right);
    }

    public Direction getLast() {
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

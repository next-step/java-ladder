package nextstep.ladder.domain.line;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;
    private DirectionSelector directionSelector;

    private Direction(boolean left, boolean right,
                      DirectionSelector directionSelector) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        this.directionSelector = directionSelector;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction getNext(boolean nextRight) {
        return of(this.right, nextRight, directionSelector);
    }

    public Direction getNext() {
        if (this.right) {
            return getNext(FALSE);
        }
        return getNext(directionSelector.hasRightDirection());
    }

    public Direction getLast() {
        return of(this.right, FALSE, directionSelector);
    }

    public static Direction of(boolean left, boolean right,
                               DirectionSelector directionSelector) {
        return new Direction(left, right, directionSelector);
    }

    public static Direction getFirst(DirectionSelector directionSelector) {
        return of(FALSE, directionSelector.hasRightDirection(),
                directionSelector);
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

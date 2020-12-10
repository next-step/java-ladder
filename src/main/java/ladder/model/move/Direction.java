package ladder.model.move;

import ladder.view.LadderItem;
import utils.RandomUtils;

import java.util.Objects;

public class Direction {
    private final static String DIRECTION_ERROR = "올바르지 못한 방향입니다.";
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

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(RandomUtils.trueOrFalse());
    }

    public static Direction of(boolean first, boolean second) {
        if(first && second){
            throw new IllegalArgumentException(DIRECTION_ERROR);
        }

        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
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
        return isRight() ? LadderItem.HORIZONTAL.getItem() : LadderItem.BLANK_HORIZONTAL.getItem();
    }
}

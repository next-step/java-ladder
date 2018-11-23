package ladderTDD.domain;

import ladder.utils.GenerateRandomUtil;

public class Direction {

    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    @Override
    public boolean equals(Object obj) {
        Direction otherDirection = (Direction)obj;
        if (this.left == otherDirection.left && this.right == otherDirection.right) {
            return true;
        }
        return false;
    }

    public Direction next() {
        if (this.right) {
            return of(this.right, false);
        }
        return of(this.right, GenerateRandomUtil.generateRandomBoolean());
    }

    public Direction next(boolean right) {
        return of(this.right, right);
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction last() {
        return of(this.right, false);
    }

    public boolean isRight() {
        return this.right;
    }
}

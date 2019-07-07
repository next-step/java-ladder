package ladder.domain;

public enum Direction {
    RIGHT(true, false),
    LEFT(false, true),
    PASS(false, false);

    final private boolean right;
    final private boolean left;

    Direction(boolean current, boolean left) {
        this.right = current;
        this.left = left;
    }

    public static Direction of(boolean current, boolean left) {
        if (current && left) {
            throw new IllegalArgumentException();
        }

        if (!current && !left) {
            return Direction.PASS;
        }

        if (current) {
            return Direction.RIGHT;
        }

        if (left) {
            return Direction.LEFT;
        }

        throw new IllegalArgumentException();
    }

    public static Direction first(boolean right) {
        return of(right, Boolean.FALSE);
    }

    public Direction next(boolean right) {
        if (this.right && !right) {
            return Direction.LEFT;
        }

        if (!this.right && right) {
            return Direction.RIGHT;
        }

        if (!this.right && !right) {
            return Direction.PASS;
        }

        throw new IllegalArgumentException();
    }

    public Direction last() {
        return of(Boolean.FALSE, this.right);
    }

    public int move(int position) {
        if (this.isRight()) {
            return position + 1;
        }

        if (this.isLeft()) {
            return position - 1;
        }

        return position;
    }

    public Boolean isRight() {
        return this == Direction.RIGHT;
    }

    public Boolean isLeft() {
        return this == Direction.LEFT;
    }
}

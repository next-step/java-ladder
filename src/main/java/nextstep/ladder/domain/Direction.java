package nextstep.ladder.domain;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean left) {
        return new Direction(left, !left);
    }

    public Direction next() {
        return this;
    }

    public Direction next(boolean b) {
        return this;
    }

    public boolean isLeft() {
        return true;
    }

    public Direction last() {
        return this;
    }
}

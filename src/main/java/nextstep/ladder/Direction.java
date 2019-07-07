package nextstep.ladder;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction() {

    }

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public static Direction first(BooleanFunction booleanFunction) {
        return new Direction(false, booleanFunction.apply(false));
    }

    public Direction next(boolean right) {
        if (this.right && right) {
            throw new IllegalArgumentException();
        }
        return of(this.right, right);
    }

    public Direction next(BooleanFunction booleanFunction) {
        return next(booleanFunction.apply(this.right));
    }

    public Direction last() {
        return next(false);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }
}

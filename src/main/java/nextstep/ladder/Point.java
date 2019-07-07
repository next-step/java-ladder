package nextstep.ladder;

public class Point {

    private final int index;
    private final boolean left;
    private final boolean right;

    public Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(0, false, right);
    }

    public static Point first(BooleanFunction booleanFunction) {
        return new Point(0, false, booleanFunction.apply(false));
    }

    public Point next(boolean right) {
        return new Point(this.index + 1, this.right, right);
    }

    public Point next(BooleanFunction booleanFunction) {
        return new Point(this.index + 1, this.right, booleanFunction.apply(this.right));
    }

    public Point last() {
        return new Point(this.index + 1, this.right, false);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public int move() {
        if (this.isLeft()) {
            return this.index - 1;
        }

        if (this.isRight()) {
            return this.index + 1;
        }

        return this.index;

    }
}

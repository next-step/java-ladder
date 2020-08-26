package ladder.domain;

public class Point {
    private boolean left;
    private boolean right;

    private Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public static Point getFirst(boolean right) {
        return new Point(false, right);
    }

    public static Point getLast(boolean left) {
        return new Point(left, false);
    }

    public static Point next(Point old, boolean right) {
        if (old.isRight()) {
            return new Point(old.isRight(), false);
        }
        return new Point(false, right);
    }

}

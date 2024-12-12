package nextstep.ladder.domain;

public class Point {

    private final boolean left;
    private final boolean right;

    public Point() {
        this(false, false);
    }

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point middle(boolean left, boolean right) {
        return new Point(left, right);
    }

    public static Point last(boolean left) {
        return new Point(left, false);
    }

    public Direction getDirection() {
        return Direction.of(left, right);
    }

    public boolean getLeft() {
        return this.left;
    }

    public boolean getRight() {
        return this.right;
    }
}

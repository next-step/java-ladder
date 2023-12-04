package ladder2.domain;

public class Point {

    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }
}

package nextstep.ladder.domain;

public class Point {

    private final boolean left;
    private final boolean right;

    public static Point first() {
        return new Point(false, true);
    }

    public static Point last() {
        return new Point(true, false);
    }

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }

        return Direction.STOP;
    }
}

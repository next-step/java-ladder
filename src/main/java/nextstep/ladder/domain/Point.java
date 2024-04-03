package nextstep.ladder.domain;

public class Point {

    private final boolean left;
    private final boolean right;

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

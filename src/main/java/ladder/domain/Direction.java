package ladder.domain;

public class Direction {

    private final int MOVE_LEFT = -1;
    private final int MOVE_RIGHT = 1;
    private final int NO_MOVE = 0;

    private final boolean left;
    private final boolean current;

    public Direction(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Direction of(Point point) {

        if (point == Point.TRUE) {
            return new Direction(true, false);
        }

        return new Direction(false, true);
    }

    public int move() {

        if (left) {
            return MOVE_LEFT;
        }

        if (current) {
            return MOVE_RIGHT;
        }

        return NO_MOVE;
    }
}

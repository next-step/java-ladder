package ladder;

public final class Point {

    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public final Direction move() {
        if(current) {
            return Direction.RIGHT;
        }
        if(left) {
            return Direction.LEFT;
        }
        return Direction.PASS;
    }
}

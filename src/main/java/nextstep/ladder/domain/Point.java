package nextstep.ladder.domain;

public class Point {

    private final boolean right;
    private final boolean current;

    public Point(boolean right,
                 boolean current) {
        this.right = right;
        this.current = current;
    }

    public Direction move() {
        if (right) {
            return Direction.RIGHT;
        }
        if (current) {
            return Direction.LEFT;
        }
        return Direction.STAY;
    }

}

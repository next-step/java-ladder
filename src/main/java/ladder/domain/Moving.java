package ladder.domain;

public class Moving {
    private static final int ONE = 1;

    private final int position;
    private final Point point;

    public Moving(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        Direction direction = point.selectDirection();
        if (direction == Direction.LEFT) {
            return position - ONE;
        }
        if (direction == Direction.RIGHT) {
            return position + ONE;
        }
        return position;
    }

    public Point getPoint() {
        return point;
    }
}

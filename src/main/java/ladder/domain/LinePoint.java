package ladder.domain;

public class LinePoint {
    private final int position;
    private final Point point;

    public LinePoint(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        Direction direction = point.move();
        if (direction == Direction.LEFT) {
            return position - 1;
        }
        if (direction == Direction.RIGHT) {
            return position + 1;
        }
        return position;
    }

    public Point getPoint() {
        return point;
    }
}

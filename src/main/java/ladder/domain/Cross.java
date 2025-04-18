package ladder.domain;

public class Cross {
    private final int position;
    private final Point point;

    public Cross(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        if (point.move().equals(Direction.RIGHT)) {
            return position + 1;
        }
        if (point.move().equals(Direction.LEFT)) {
            return position - 1;
        }
        return position;
    }

    public boolean getCurrent() {
        return point.getCurrent();
    }
}

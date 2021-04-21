package ladder;

public final class Cross {

    private final int position;
    private final Point point;

    public Cross(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        if (point.move() == Direction.RIGHT) {
            return position + 1;
        }
        return 0;
    }
}

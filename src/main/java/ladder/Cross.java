package ladder;

public class Cross {
    private final Position position;
    private final Point point;

    public Cross(Position poisition, Point point) {
        this.position = poisition;
        this.point = point;
    }

    public Position move() {
        if (point.move() == Direction.RIGHT) {
            return position.left();
        }
        if (point.move() == Direction.LEFT) {
            return position.right();
        }
        return position;
    }
}

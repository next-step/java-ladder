package ladder.domain;

public class Point {

    public static final Point EMPTY = create();

    private Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point create() {
        return new Point(Direction.NONE);
    }

    public int step() {
        return Direction.findStep(direction);
    }

    public boolean canConnect() {
        return Direction.isNone(this.direction);
    }

    public Point connect(Point point) {
        if(this.canConnect() && point.canConnect()) {
            this.connect(Direction.RIGHT);
            point.connect(Direction.LEFT);
        }
        return this;
    }

    private void connect(Direction direction) {
        this.direction = direction;
    }

    public boolean isConnected() {
        return !Direction.isNone(this.direction);
    }

    @Override
    public String toString() {
        return direction.toString();
    }
}

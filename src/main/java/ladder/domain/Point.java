package ladder.domain;

public class Point {

    private Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point create() {
        return new Point(Direction.NONE);
    }

    public int position() {
        return Direction.findPosition(direction);
    }

    public boolean canConnect() {
        return Direction.isNone(this.direction);
    }

    public void connect(Direction direction) {
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

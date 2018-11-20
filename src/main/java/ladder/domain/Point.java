package ladder.domain;

public class Point {

    private Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point create() {
        return new Point(Direction.NONE);
    }

    public boolean canConnect() {
        return Direction.isNone(this.direction);
    }

    public void connect(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction.toString();
    }
}

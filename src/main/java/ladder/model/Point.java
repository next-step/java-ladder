package ladder.model;

public final class Point {
    public static final String MESSAGE_OF_TWO_WAY_CONNECTION = "Point는 양방향으로 연결할 수 없습니다.";

    public static Point firstOf(ConnectorStrategy connector) {
        return new Point(0, Direction.firstOf(connector));
    }

    private final int position;
    private final Direction direction;

    private Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Point nextOf(ConnectorStrategy connector) {
        return new Point(position + 1, direction.nextOf(connector));
    }

    public Point endOf() {
        return new Point(position + 1, direction.endOf());
    }

    public boolean isConnectedRight() {
        return direction == Direction.RIGHT;
    }

    public int move() {
        return direction.move(position);
    }
}

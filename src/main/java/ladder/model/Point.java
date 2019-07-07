package ladder.model;

public final class Point {
    public static final String MESSAGE_OF_TWO_WAY_CONNECTION = "Point는 양방향으로 연결할 수 없습니다.";

    public static Point firstOf(ConnectorStrategy connector) {
        final boolean firstConnection = connector.generateNextConnection(false);
        return new Point(position);
    }

    private int position;
    private Direction direction;

    private Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Point nextOf(ConnectorStrategy connector) {
        final Direction nextDirection = connector.generateNextConnection(direction);
        return new Point(position + 1, nextDirection);
    }

    public Point endOf() {
        final Direction nextDirection = (direction == Direction.RIGHT) ? Direction.LEFT : Direction.DOWN;
        return new Point(position + 1, nextDirection);
    }

    public boolean isConnectedRight() {
        return direction == Direction.RIGHT;
    }

    public int move() {
        return direction.move(position);
    }
}

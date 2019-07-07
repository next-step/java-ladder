package ladder.model;

public final class Point {
    public static final String MESSAGE_OF_TWO_WAY_CONNECTION = "Point는 양방향으로 연결할 수 없습니다.";

    public static Point firstOf(ConnectorStrategy connector) {
        final boolean firstConnection = connector.generateConnection(false);
        return new Point(0, false, firstConnection);
    }

    private int position;
    private final boolean left;
    private final boolean right;

    private Point(int position, boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(MESSAGE_OF_TWO_WAY_CONNECTION);
        }

        this.position = position;
        this.left = left;
        this.right = right;
    }

    public Point nextOf(ConnectorStrategy connector) {
        final boolean nextConnection = connector.generateConnection(right);
        return new Point(position + 1, right, nextConnection);
    }

    public Point endOf() {
        return new Point(position + 1, right, false);
    }

    public boolean isConnectedRight() {
        return right;
    }

    public int move() {
        if (right) {
            position++;
        }
        if (left) {
            position--;
        }
        return position;
    }
}

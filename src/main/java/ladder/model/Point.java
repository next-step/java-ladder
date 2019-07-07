package ladder.model;

public final class Point {
    public static Point firstOf(ConnectorStrategy connector) {
        final boolean firstConnection = connector.generateConnection(false);
        return new Point(false, firstConnection);
    }

    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Point는 양방향으로 연결할 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public Point nextOf(ConnectorStrategy connector) {
        final boolean nextConnection = connector.generateConnection(right);
        return new Point(right, nextConnection);
    }

    public Point endOf() {
        return new Point(right, false);
    }

    public boolean isConnectedRight() {
        return right;
    }
}

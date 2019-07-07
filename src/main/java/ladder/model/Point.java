package ladder.model;

public final class Point {
    public static Point firstOf(ConnectorStrategy connector) {
        final boolean firstConnection = connector.generateConnection(false);
        return new Point(firstConnection);
    }

    private final boolean right;

    private Point(boolean right) {
        this.right = right;
    }

    public Point nextOf(ConnectorStrategy connector) {
        final boolean nextConnection = connector.generateConnection(right);
        return new Point(nextConnection);
    }

    public Point endOf() {
        return new Point(false);
    }

    public boolean isConnectedRight() {
        return right;
    }
}

package ladder.domain;

public class Connection {

    public static final Connection EMPTY = new Connection(Point.create(), Point.create());

    private final Point start;
    private final Point end;

    private Connection(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public static Connection create(Point start, Point end) {
        return new Connection(start, end);
    }

    public Connection connect() {
        if (this.canConnect()) {
            start.connect(Direction.RIGHT);
            end.connect(Direction.LEFT);
        }
        return this;
    }

    private boolean canConnect() {
        return start.canConnect() && end.canConnect();
    }

    public boolean isConnected() {
        return start.isConnected() && end.isConnected();
    }
}

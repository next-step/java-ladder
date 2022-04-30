package nextstep.ladder.model;

public final class Point {

    private static final Point CONNECTED = new Point(true);
    private static final Point DISCONNECTED = new Point(false);

    private final boolean connected;

    private Point(boolean connected) {
        this.connected = connected;
    }

    static Point connected() {
        return CONNECTED;
    }

    static Point disconnected() {
        return DISCONNECTED;
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public String toString() {
        return "Point{" +
                "connected=" + connected +
                '}';
    }
}

package nextstep.ladder.domain;

public class Point {
    private boolean connected;

    private Point() {
        this.connected = false;
    }

    public static Point create() {
        return new Point();
    }

    public void connect() {
        this.connected = true;
    }

    public boolean isConnected() {
        return connected;
    }
}

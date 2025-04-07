package nextstep.ladder.domain;

public class Point {
    private final boolean connected;

    public Point(boolean connected) {
        this.connected = connected;
    }

    public boolean isConnected() {
        return connected;
    }
}

package nextstep.ladder.domain;

public class Point {

    private boolean connected;

    public Point(boolean connected) {
        this.connected = connected;
    }

    public boolean connectable() {
        return !connected;
    }
}

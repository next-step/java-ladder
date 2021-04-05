package nextstep.ladder.domain;

public class Point {

    private static final String CONNECTED = "|-----";
    private static final String NOT_CONNECTED = "|     ";

    private boolean connected;

    public Point(boolean connected) {
        this.connected = connected;
    }

    public boolean connectable() {
        return !connected;
    }

    public String draw() {
        return connected ? CONNECTED : NOT_CONNECTED;
    }
}

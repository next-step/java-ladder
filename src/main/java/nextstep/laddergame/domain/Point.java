package nextstep.laddergame.domain;

public class Point {

    private final boolean isConnected;

    public Point(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean isConnected() {
        return isConnected;
    }
}

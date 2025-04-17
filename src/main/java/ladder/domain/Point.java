package ladder.domain;

public class Point {
    private final Boolean connect;

    public Point(Boolean connect) {
        this.connect = connect;
    }

    public Boolean isConnected() {
        return connect;
    }
}

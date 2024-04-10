package nextstep.ladder.domain.ladder;

public class Point {

    private final Boolean connect;

    private Point(Boolean connect) {
        this.connect = connect;
    }

    public static Point of(Boolean connect) {
        return new Point(connect);
    }

    public boolean isConnected() {
        return this.connect;
    }
}

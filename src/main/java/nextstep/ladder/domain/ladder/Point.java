package nextstep.ladder.domain.ladder;

public class Point {
    private final boolean connect;

    public Point(boolean connect) {
        this.connect = connect;
    }

    public boolean isConnect() {
        return connect;
    }
}

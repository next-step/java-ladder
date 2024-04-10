package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.PointGenerator;

public class Point {

    private final Boolean connect;

    private Point(Boolean connect) {
        this.connect = connect;
    }

    public static Point of(Boolean connect) {
        return new Point(connect);
    }

    public static Point generatePoint(PointGenerator strategy) {
        return new Point(strategy.generate());
    }

    public boolean isConnected() {
        return this.connect;
    }
}

package nextstep.ladder.domain;

import nextstep.ladder.domain.vo.Point;

import java.util.Set;

public class ConnectPoints {
    private final Set<Point> points;

    private ConnectPoints(final Set<Point> points) {
        this.points = points;
    }

    public static ConnectPoints of(final Set<Point> points) {
        return new ConnectPoints(points);
    }

    public boolean has(Point point) {
        return points.contains(point);
    }
}

package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Set;

public class ConnectPoints {
    private final Set<Point> points;

    public ConnectPoints(final Set<Point> points) {
        this.points = Collections.unmodifiableSet(points);
    }

    public boolean hasPoint(Point point) {
        return points.contains(point);
    }
}

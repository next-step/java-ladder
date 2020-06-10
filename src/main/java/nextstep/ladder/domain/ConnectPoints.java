package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Set;

public class ConnectPoints {
    int maxHeight = 5;
    private final Set<Point> points;

    public ConnectPoints(final Set<Point> points) {
        if (points.removeIf(point -> point.getPosition() > maxHeight)) {
            throw new IllegalArgumentException(String.format("Point의 최대높이는 %d를 넘을 수 없습니다", maxHeight));
        }
        this.points = Collections.unmodifiableSet(points);
    }

    public boolean hasPoint(Point point) {
        return points.contains(point);
    }
}

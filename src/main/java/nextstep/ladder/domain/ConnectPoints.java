package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Set;

public class ConnectPoints {
    private final Set<Point> points;

    public ConnectPoints(final Set<Point> points, final int maxHeight) {
        this.points = points;
        validateNumberOfPoints(maxHeight);
    }

    public ConnectPoints(ConnectPoints connectPoints) {
        this.points = Collections.unmodifiableSet(connectPoints.points);
    }

    private void validateNumberOfPoints(int maxHeight) {
        if (this.points.size() >= maxHeight) {
            throw new IllegalArgumentException("최대높이 이상의 Points를 가질 수 없습니다.");
        }
    }

    public boolean hasPoint(Point point) {
        return points.contains(point);
    }
}

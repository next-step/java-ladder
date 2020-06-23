package nextstep.ladder.domain;

import nextstep.ladder.domain.vo.Point;

import java.util.Set;

public class LadderLine {
    private final Set<Point> points;

    private LadderLine(final Set<Point> points) {
        this.points = points;
    }

    public static LadderLine of(final Set<Point> points) {
        return new LadderLine(points);
    }

    public boolean connectedWith(final Point point) {
        return points.contains(point);
    }

}

package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.point.Point;
import nextstep.ladder.domain.line.point.Points;

import java.util.List;

public class Line {
    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Line(int pointCount) {
        this(new Points(pointCount, new RandomLineGenerator()));
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

}

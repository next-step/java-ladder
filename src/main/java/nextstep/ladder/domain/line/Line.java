package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.point.Point;
import nextstep.ladder.domain.line.point.Points;

import java.util.List;

public class Line {
    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public static Line of(int count) {
        return new Line(Points.of(count, new RandomLineGenerator()));
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

}

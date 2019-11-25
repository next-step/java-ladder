package nextstep.ladder.domain.line;

import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.Points;

import java.util.List;

public class Line {

    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Line(int count) {
        this(new Points(count));
    }

    public List<Point> getPoints() {
        return points.getValue();
    }

    public int move(int startPosition) {
        return points.move(startPosition);
    }
}

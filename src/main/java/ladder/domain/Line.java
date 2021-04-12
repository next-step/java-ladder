package ladder.domain;

import java.util.List;

public final class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static final Line of(List<Point> points) {
        return new Line(points);
    }

}

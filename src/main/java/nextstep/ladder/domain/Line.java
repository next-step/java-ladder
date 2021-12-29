package nextstep.ladder.domain;

import java.util.List;

/**
 * @author han
 */
public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}

package ladder.domain.ladder.line;

import java.util.List;
import java.util.Optional;
import ladder.domain.ladder.point.Point;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public int permute(int index) {
        return Optional.ofNullable(points.get(index))
                .map(Point::permute)
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public static Line init(boolean right) {
        List<Point> points = new ArrayList<>();
        points.add(Point.getFirst(right));

        return Line.of(points);
    }

    public int getSize() {
        return points.size();
    }

    public List<Boolean> getConnection() {
        return points.stream()
                .map(Point::isRight)
                .collect(Collectors.toList());
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point getFirst() {
        return points.get(0);
    }
}

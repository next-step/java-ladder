package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final static int FIRST_POINT_COUNT = 1;
    private final static int LAST_POINT_COUNT = 1;
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int count) {
        this.points = init(count);
    }

    private List<Point> init(int count) {
        List<Point> points = new ArrayList<>();

        PointGenerator pointGenerator = new PointGenerator(points);
        Point point = pointGenerator.first();
        Point lastBodyPoint = pointGenerator.body(bodyCount(count), point);
        pointGenerator.last(lastBodyPoint);

        return points;
    }

    private int bodyCount(int count) {
        return count - (FIRST_POINT_COUNT + LAST_POINT_COUNT);
    }

    public int move(int positionIndex) {
        return points.get(positionIndex).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

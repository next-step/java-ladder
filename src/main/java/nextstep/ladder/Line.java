package nextstep.ladder;

import nextstep.UniformRandomBooleanProvider;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int count) {
        points = createPoints(count);
    }

    private List<Point> createPoints(int count) {
        List<Point> points = new ArrayList<>();

        Point firstPoint = Point.createRandomlyHorizontalLine(new UniformRandomBooleanProvider());
        points.add(firstPoint);

        for (int i = 1; i < count - 1; i++) {
            Point previousPoint = points.get(i - 1);
            points.add(createHorizontalPoints(previousPoint));
        }

        return points;
    }

    private Point createHorizontalPoints(Point previousPoint) {
        if (previousPoint.hasConnection()) {
            return Point.createEmpty();
        }

        return Point.createRandomlyHorizontalLine(new UniformRandomBooleanProvider());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.toString());
        }
        return sb.toString();
    }
}

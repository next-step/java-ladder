package nextstep.ladder;

import nextstep.UniformRandomBooleanProvider;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private List<Point> points;

    public Points(int count) {
        points = createPoints(count);
    }

    private List<Point> createPoints(int count) {
        List<Point> totalPoints = new ArrayList<>();
        Point currentHorizontalPoint = null;

        for (int i = 0; i < count; i++) {
            totalPoints.add(Point.createVerticalLine());

            currentHorizontalPoint = createHorizontalPoint(currentHorizontalPoint);
            totalPoints.add(currentHorizontalPoint);
        }

        totalPoints.add(Point.createVerticalLine());

        return totalPoints;
    }

    private Point createHorizontalPoint(Point previousPoint) {
        if (previousPoint == null || !previousPoint.hasConnection()) {
            return Point.createRandomlyHorizontalLine(new UniformRandomBooleanProvider());
        }

        return Point.createEmpty();
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

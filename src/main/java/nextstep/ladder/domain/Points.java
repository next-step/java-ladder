package nextstep.ladder.domain;

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

    public List<Point> getValue() {
        return new ArrayList<>(points);
    }
}

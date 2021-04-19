package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {
    private static final int FIRST_POINT_COUNT = 1;
    private static final int LAST_POINT_COUNT = 1;

    private PointGenerator() {
    }

    public static List<Point> makePoints(int count) {
        List<Point> points = new ArrayList<>();

        Point firstPoint = first(points);
        Point lastBodyPoint = body(bodyCount(count), firstPoint, points);
        last(lastBodyPoint, points);

        return points;
    }

    private static Point first(List<Point> points) {
        Point firstPoint = generate(new FirstPointStrategy(RandomUtil.trueOrFalse()));
        points.add(firstPoint);
        return firstPoint;
    }

    private static Point body(int count, Point firstPoint, List<Point> points) {
        Point previousPoint = firstPoint;
        for (int i = 0; i < count; i++) {
            Point currentPoint = generate(new BodyPointStrategy(previousPoint, RandomUtil.trueOrFalse()));
            points.add(currentPoint);
            previousPoint = currentPoint;
        }
        return previousPoint;
    }

    private static void last(Point previousPoint, List<Point> points) {
        Point lastPoint = generate(new LastPointStrategy(previousPoint));
        points.add(lastPoint);
    }

    private static Point generate(PointStrategy pointStrategy) {
        return pointStrategy.point();
    }

    private static int bodyCount(int count) {
        return count - (FIRST_POINT_COUNT + LAST_POINT_COUNT);
    }
}

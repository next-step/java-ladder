package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {
    private static final int FIRST_POINT_COUNT = 1;
    private static final int LAST_POINT_COUNT = 1;

    private final List<Point> points;
    private final int pointCount;

    private PointGenerator(int pointCount) {
        this.points = new ArrayList<>();
        this.pointCount = pointCount;
    }

    public static PointGenerator of(int pointCount) {
        return new PointGenerator(pointCount);
    }

    public Point first() {
        Point firstPoint = generate(new FirstPointStrategy(RandomUtil.trueOrFalse()));
        points.add(firstPoint);
        return firstPoint;
    }

    public Point body(Point firstPoint) {
        Point previousPoint = firstPoint;
        for (int i = 0; i < bodyCount(); i++) {
            Point currentPoint = generate(new BodyPointStrategy(previousPoint, RandomUtil.trueOrFalse()));
            points.add(currentPoint);
            previousPoint = currentPoint;
        }
        return previousPoint;
    }

    public void last(Point previousPoint) {
        Point lastPoint = generate(new LastPointStrategy(previousPoint));
        points.add(lastPoint);
    }

    private Point generate(PointStrategy pointStrategy) {
        return pointStrategy.point();
    }

    private int bodyCount() {
        return pointCount - (FIRST_POINT_COUNT + LAST_POINT_COUNT);
    }

    public List<Point> toPoints() {
        return points;
    }
}

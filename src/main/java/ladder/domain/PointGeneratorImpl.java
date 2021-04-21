package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class PointGeneratorImpl implements PointGeneratorInterface {
    private static final int FIRST_POINT_COUNT = 1;
    private static final int LAST_POINT_COUNT = 1;

    private final List<Point> points;

    public PointGeneratorImpl() {
        this.points = new ArrayList<>();
    }

    @Override
    public List<Point> generate(int with) {
        Point firstPoint = first();
        Point lastBodyPoint = body(bodyCount(with), firstPoint);
        last(lastBodyPoint);
        return points;
    }

    private Point first() {
        Point firstPoint = generate(new FirstPointStrategy(RandomUtil.trueOrFalse()));
        points.add(firstPoint);
        return firstPoint;
    }

    private Point body(int bodyCount, Point firstPoint) {
        Point previousPoint = firstPoint;
        for (int i = 0; i < bodyCount; i++) {
            Point currentPoint = generate(new BodyPointStrategy(previousPoint, RandomUtil.trueOrFalse()));
            points.add(currentPoint);
            previousPoint = currentPoint;
        }
        return previousPoint;
    }

    private void last(Point previousPoint) {
        Point lastPoint = generate(new LastPointStrategy(previousPoint));
        points.add(lastPoint);
    }

    private Point generate(PointStrategy pointStrategy) {
        return pointStrategy.point();
    }

    private int bodyCount(int pointCount) {
        return pointCount - (FIRST_POINT_COUNT + LAST_POINT_COUNT);
    }
}

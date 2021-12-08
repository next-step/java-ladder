package step4.strategy;

import step4.domain.Point;
import step4.utils.RandomBooleanUtil;

import java.util.ArrayList;
import java.util.List;

public class RandomPointCreateStrategy implements PointCreateStrategy {
    private static final int INCREASE_STEP = 1;

    @Override
    public List<Point> create(int count) {
        return init(count);
    }

    private List<Point> init(int count) {
        List<Point> points = new ArrayList<>();
        Point point = initStart(points);
        point = initMiddle(points, point, count);
        initLast(points, point);
        return points;
    }

    private Point initStart(List<Point> points) {
        Point startPoint = Point.start(generateBoolean());
        points.add(startPoint);
        return startPoint;
    }

    private Point initMiddle(List<Point> points, Point point, int count) {
        for (int step = INCREASE_STEP; step < count - INCREASE_STEP; step++) {
            point = point.next(generateBoolean());
            points.add(point);
        }
        return point;
    }

    private void initLast(List<Point> points, Point point) {
        Point lastPoint = point.last();
        points.add(lastPoint);
    }

    private boolean generateBoolean() {
        return RandomBooleanUtil.nextBoolean();
    }
}

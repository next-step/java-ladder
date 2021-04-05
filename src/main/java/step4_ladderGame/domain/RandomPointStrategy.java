package step4_ladderGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointStrategy implements CreatePointStrategy {

    private static final Random random = new Random();

    @Override
    public boolean test(boolean lastPoint) {
        if (lastPoint) {
            return false;
        }
        return random.nextBoolean();
    }

    @Override
    public List<Point> createPoint(int playerCount) {
        List<Point> points = new ArrayList<>();
        Point point = firstPoint(points);
        Point next = nextPoint(point, points, playerCount);
        lastPoint(next, points);
        return points;
    }

    private Point nextPoint(Point point, List<Point> points, int playerCount) {
        Point next = point;
        for (int i = 0; i < playerCount - 2; i++) {
            next = next.next(test(next.current()));
            points.add(next);
        }
        return next;
    }

    private void lastPoint(Point point, List<Point> points) {
        points.add(point.last());
    }

    private Point firstPoint(List<Point> points) {
        Point first = Point.first(random.nextBoolean());
        points.add(first);
        return first;
    }

    private RandomPointStrategy() {
    }

    private static class StrategyHolder {
        public static final RandomPointStrategy INSTANCE = new RandomPointStrategy();
    }

    public static RandomPointStrategy getInstance() {
        return StrategyHolder.INSTANCE;
    }
}

package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDrawingLineStrategy implements DrawingLineStrategy {
    private static final int ONE = 1;
    private static final int INDEX_CONSTANT = 1;
    private static final Random RANDOM = new Random();

    @Override
    public List<Point> drawLine(int playerCounts) {
        List<Point> points = new ArrayList<>();
        points.add(Point.drawFirstPoint(generateRandomBoolean()));
        for (int i = ONE; i < playerCounts - ONE; i++) {
            Point point = drawPoint(i, points);
            points.add(point);
        }
        if (isLastPointConnected(points)) {
            points.add(Point.drawLastPoint(playerCounts - 1, false));
        } else {
            points.add(Point.drawLastPoint(playerCounts - 1, true));
        }
        return points;
    }

    private Point drawPoint(int index, List<Point> points) {
        if (isLastPointConnected(points)) {
            return new Point(index, Direction.LEFT);
        }
        return Point.drawMiddlePoint(index, generateRandomBoolean());
    }

    private boolean isLastPointConnected(List<Point> points) {
        int lastPointIndex = points.size() - INDEX_CONSTANT;
        Point lastPoint = points.get(lastPointIndex);
        return lastPoint.getDirection() == Direction.RIGHT;
    }

    private boolean generateRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}

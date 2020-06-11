package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDrawingLineStrategy implements DrawingLineStrategy {
    private static final int LOOP_ZERO = 0;
    private static final int INDEX_CONSTANT = 1;
    private static final Random RANDOM = new Random();

    @Override
    public List<Point> drawLine(int playerCounts) {
        List<Point> points = new ArrayList<>();
        int lineWidth = playerCounts;
        for (int i = LOOP_ZERO; i < lineWidth; i++) {
            Point point = drawPoint(i, playerCounts, points);
            points.add(point);
        }
        return points;
    }

    private Point drawPoint(int index, int playerCounts, List<Point> points) {
        if (points.isEmpty()) {
            return Point.drawFirstPoint(playerCounts, index, generateRandomBoolean());
        }
        if (isLastPointConnected(points)) {
            return new Point(index, Direction.DOWN);
        }
        if (points.size() == playerCounts - 1) {
            return Point.drawLastPoint(index, generateRandomBoolean());
        }
        int randomNumber = RANDOM.nextInt(3);
        return Point.drawPoint(index, randomNumber);
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

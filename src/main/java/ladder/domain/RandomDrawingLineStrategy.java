package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDrawingLineStrategy implements DrawingLineStrategy {
    private static final int TWO = 2;
    private static final int INDEX_CONSTANT = 1;
    private static final Random RANDOM = new Random();

    @Override
    public List<Point> drawLine(int playerCounts) {
        List<Point> points = new ArrayList<>();
        drawFirstPoint(points);
        drawMiddlePoints(playerCounts, points);
        drawLastPoints(points);
        return points;
    }

    private void drawFirstPoint(List<Point> points) {
        points.add(Point.drawFirstPoint(generateRandomBoolean()));
    }

    private void drawLastPoints(List<Point> points) {
        int lastPointIndex = points.size() - INDEX_CONSTANT;
        Point lastPoint = points.get(lastPointIndex);
        points.add(Point.drawLastPoint(lastPoint));
    }

    private void drawMiddlePoints(int playerCounts, List<Point> points) {
        for (int i = 0; i < playerCounts - TWO; i++) {
            Point lastPoint = points.get(i);
            Point point = Point.drawMiddlePoint(lastPoint, generateRandomBoolean());
            points.add(point);
        }
    }

    private boolean generateRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}

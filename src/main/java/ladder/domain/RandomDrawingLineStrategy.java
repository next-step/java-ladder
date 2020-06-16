package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDrawingLineStrategy implements DrawingLineStrategy {
    private static final int LOOP_ZERO = 0;
    private static final int INDEX_CONSTANT = 1;
    private static final int TWO = 2;
    private static final Random RANDOM = new Random();

    @Override
    public List<Point> drawLine(int playerCounts) {
        List<Point> points = new ArrayList<>();
        drawFirstPoint(points);
        drawMiddlePoints(playerCounts, points);
        drawLastPoint(points);
        return points;
    }

    private void drawFirstPoint(List<Point> points) {
        points.add(Point.drawFirstPoint(generateRandomBoolean()));
    }

    private void drawLastPoint(List<Point> points) {
        int lastPointIndex = points.size() - INDEX_CONSTANT;
        Point lastPoint = points.get(lastPointIndex);
        points.add(Point.drawLastPoint(lastPoint));
    }

    private void drawMiddlePoints(int playerCounts, List<Point> points) {
        for (int i = LOOP_ZERO; i < playerCounts - TWO; i++) {
            Point lastPoint = points.get(i);
            Point nextPoint = Point.drawMiddlePoint(lastPoint, generateRandomBoolean());
            points.add(nextPoint);
        }
    }

    private boolean generateRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}

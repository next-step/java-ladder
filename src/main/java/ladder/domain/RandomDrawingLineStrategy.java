package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDrawingLineStrategy implements DrawingLineStrategy {

    private static final int LOOP_ZERO = 0;
    private static final int LINE_WIDTH_CONSTANT = 1;
    private static final int INDEX_CONSTANT = 1;
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final Random random = new Random();

    @Override
    public List<Point> drawLine(int playerCounts) {
        List<Point> points = new ArrayList<>();
        int lineWidth = playerCounts - LINE_WIDTH_CONSTANT;
        for (int i = LOOP_ZERO; i < lineWidth; i++) {
            Point point = drawPoint(points);
            points.add(point);
        }
        return points;
    }

    private Point drawPoint(List<Point> points) {
        int randomNumber = generateRandomNumber();
        if (points.isEmpty()) {
            return Point.of(randomNumber);
        }
        if (isFormerPointOnPosition(points)) {
            return new Point(false);
        }
        return Point.of(randomNumber);
    }

    private boolean isFormerPointOnPosition(List<Point> points) {
        int formerPointIndex = points.size() - INDEX_CONSTANT;
        Point formerPoint = points.get(formerPointIndex);
        return formerPoint.getIsOnPosition();
    }

    private int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}

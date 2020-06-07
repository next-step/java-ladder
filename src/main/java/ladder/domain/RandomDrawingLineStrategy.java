package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDrawingLineStrategy implements DrawingLineStrategy {

    private static final Random random = new Random();

    @Override
    public List<Point> drawLine(int playerCounts) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < playerCounts - 1; i++) {
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
        int currentIndex = points.size() - 1;
        Point point = points.get(currentIndex);

        if (point.getIsOnCurrentPosition()) {
            return new Point(false);
        }
        return Point.of(randomNumber);
    }

    private int generateRandomNumber() {
        return random.nextInt(10);
    }
}

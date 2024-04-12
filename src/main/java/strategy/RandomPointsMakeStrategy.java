package strategy;

import domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointsMakeStrategy implements PointsMakeStrategy {
    private static final Random RANDOM = new Random();
    @Override
    public List<Point> makePoints(int playerCount) {
        List<Point> points = new ArrayList<>();
        boolean isPreviousTrue = false;
        for (int i = 0; i < playerCount - 1; i++) {
            isPreviousTrue = addPoint(isPreviousTrue, points);
        }
        return points;
    }

    private boolean addPoint(boolean isPreviousTrue, List<Point> points) {
        if (isPreviousTrue) {
            points.add(new Point(false));
            return false;
        }
        boolean currentPoint = RANDOM.nextBoolean();
        points.add(new Point(currentPoint));

        return currentPoint;
    }
}

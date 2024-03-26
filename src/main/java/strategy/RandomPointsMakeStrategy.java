package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointsMakeStrategy implements PointsMakeStrategy {
    private static Random RANDOM = new Random();
    @Override
    public List<Boolean> makePoints(int playerCount) {
        List<Boolean> points = new ArrayList<>();
        boolean isPreviousTrue = false;
        for (int i = 0; i < playerCount - 1; i++) {
            isPreviousTrue = addPoint(isPreviousTrue, points);
        }
        return points;
    }

    private static boolean addPoint(boolean isPreviousTrue, List<Boolean> points) {
        if (isPreviousTrue) {
            points.add(false);
            return false;
        }
        boolean currentPoint = RANDOM.nextBoolean();
        points.add(currentPoint);

        return currentPoint;
    }
}

package strategy;

import domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointsMakeStrategy implements PointsMakeStrategy {
    private static final Random RANDOM = new Random();
    public static final int SECOND_PLAYER_POSITION = 1;

    @Override
    public List<Point> makePoints(int playerCount) {
        List<Point> points = new ArrayList<>();

        boolean currentPoint = getRandomBoolean();
        points.add(Point.first(currentPoint));
        final int positionOfSecondFromLastPlayer = playerCount - 2;
        for (int i = SECOND_PLAYER_POSITION; i < positionOfSecondFromLastPlayer; i++) {
            currentPoint = addPoint(currentPoint, points);
        }
        points.add(Point.last(currentPoint));

        return points;
    }

    private boolean addPoint(boolean isPreviousTrue, List<Point> points) {
        if (isPreviousTrue) {
            points.add(Point.of(true, false));
            return false;
        }
        boolean currentPoint = getRandomBoolean();
        points.add(Point.of(false, currentPoint));

        return currentPoint;
    }

    private boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}

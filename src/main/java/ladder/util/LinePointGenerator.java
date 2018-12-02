package ladder.util;

import ladder.model.Arrow;
import ladder.model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LinePointGenerator {
    private static final Random random = new Random();
    private static final int BEGIN_INDEX = 1;

    public static List<Point> generate(int countOfPoint) {
        if (countOfPoint < 1) {
            throw new IllegalArgumentException();
        }

        int maxIndexOfPoint = countOfPoint - 1;
        List<Point> points = new ArrayList<>(Arrays.asList(generateBeginPoint()));
        IntStream.range(BEGIN_INDEX, maxIndexOfPoint)
                .forEach(index -> points.add(generateNextPoint(index, getLastPoint(points))));
        points.add(generateEndPoint(maxIndexOfPoint, getLastPoint(points)));
        return points;
    }

    private static Point getLastPoint(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return points.get(points.size() - 1);
    }

    private static boolean getRandomStatus() {
        return random.nextBoolean();
    }

    private static Point generateBeginPoint() {
        return Point.from(0, Arrow.valueOf(false, getRandomStatus()));
    }

    private static Point generateEndPoint(int endIndex, Point currentPoint) {
        return Point.from(endIndex, Arrow.valueOf(currentPoint.isRight(), false));
    }

    private static Point generatePoint(int index, Point currentPoint) {
        if (currentPoint.isRight()) {
            return Point.from(index, Arrow.LEFT);
        }

        return Point.from(index, Arrow.valueOf(false, getRandomStatus()));
    }

    private static Point generateNextPoint(int nextIndex, Point currentPoint) {
        Point nextPoint = generatePoint(nextIndex, currentPoint);
        return currentPoint.isCollapse(nextPoint) ? Point.from(nextIndex, Arrow.LEFT) : nextPoint;
    }
}

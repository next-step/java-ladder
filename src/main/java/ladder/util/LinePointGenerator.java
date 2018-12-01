package ladder.util;

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

        List<Point> points = new ArrayList<>(Arrays.asList(getRandomPoint()));
        IntStream.range(BEGIN_INDEX, countOfPoint)
                .forEach(index -> {
                    points.add(generateNextPoint(getPrevPoint(points, index)));
                });
        return points;
    }

    private static Point getPrevPoint(List<Point> points, int currentIndex) {
        if (currentIndex < 1) {
            throw new IllegalArgumentException();
        }

        return points.get(currentIndex - 1);
    }

    private static Point getRandomPoint() {
        return Point.from(random.nextBoolean());
    }

    private static Point generateNextPoint(Point currentPoint) {
        Point nextPoint = getRandomPoint();
        return currentPoint.isCollapse(nextPoint) ? Point.from(false) : nextPoint;
    }
}

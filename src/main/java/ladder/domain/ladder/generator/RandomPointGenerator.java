package ladder.domain.ladder.generator;

import ladder.domain.ladder.Point;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private static final Random RANDOM = new Random();
    private static final List<Point> POINTS_FOR_LEFTMOST =
            Arrays.asList(Point.CANNOT_CROSS_POINT, Point.RIGHT_CROSS_POINT);

    @Override
    public Point generate(Point previous) {
        // - |
        if (previous.canCrossRight()) {
            return Point.LEFT_CROSS_POINT;
        }

        //   |   or   | -
        return generateLeftmost();
    }

    @Override
    public Point generateLeftmost() {
        //   |   or   | -
        return getRandomPointFromPoints(POINTS_FOR_LEFTMOST);
    }

    @Override
    public Point generateRightmost(Point previous) {
        // - |
        if (previous.canCrossRight()) {
            return Point.LEFT_CROSS_POINT;
        }

        //   |
        return Point.CANNOT_CROSS_POINT;
    }

    private Point getRandomPointFromPoints(List<Point> points) {
        int randomIndex = RANDOM.nextInt(points.size());
        return points.get(randomIndex);
    }
}

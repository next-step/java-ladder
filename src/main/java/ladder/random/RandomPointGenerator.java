package ladder.random;

import ladder.domain.ladder.Point;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private final Random random = new Random();
    private final Point[] points = Point.values();

    @Override
    public Point generate() {
        int bound = points.length;
        return points[random.nextInt(bound)];
    }
}

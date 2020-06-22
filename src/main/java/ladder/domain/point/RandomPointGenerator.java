package ladder.domain.point;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private static final Random random = new Random();

    private Point prevPoint = Point.zero();

    public RandomPointGenerator() {
    }

    @Override
    public Point next() {
        prevPoint = generate();
        return prevPoint;
    }

    private Point generate() {
        if (prevPoint.isEmpty()) {
            return random.nextBoolean() ? Point.five() : Point.zero();
        }

        return Point.zero();
    }
}

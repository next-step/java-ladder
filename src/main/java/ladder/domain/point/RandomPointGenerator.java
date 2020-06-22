package ladder.domain.point;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private static final Random random = new Random();

    private Point prevPoint = Point.disconnect();

    public RandomPointGenerator() {
    }

    @Override
    public Point next() {
        prevPoint = generate();
        return prevPoint;
    }

    private Point generate() {
        if (!prevPoint.isConnect()) {
            return random.nextBoolean() ? Point.connect() : Point.disconnect();
        }

        return Point.disconnect();
    }
}

package ladder.domain.point;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private static final Random random = new Random();

    private Point prevPoint = Point.first();

    public RandomPointGenerator() {
    }

    @Override
    public Point next() {
        prevPoint = generate();
        return prevPoint;
    }

    private Point generate() {
        if (!prevPoint.isMovable()) {
            return Point.create(random.nextBoolean());
        }

        return Point.create(false);
    }
}

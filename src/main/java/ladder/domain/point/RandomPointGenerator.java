package ladder.domain.point;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private static final Random random = new Random();

    private Point prevPoint = Point.first();
    private int index = 1;

    public RandomPointGenerator() {
    }

    @Override
    public Point next() {
        prevPoint = generate();
        return prevPoint;
    }

    private Point generate() {
        if (!prevPoint.isMovable()) {
            return Point.create(index++, random.nextBoolean());
        }

        return Point.create(index++, false);
    }
}

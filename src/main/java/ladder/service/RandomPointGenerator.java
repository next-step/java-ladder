package ladder.service;

import ladder.domain.Point;

import java.util.List;
import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public Point generate(int index, List<Point> points) {
        if (index > 0 && points.get(index - 1).isConnected()) {
            return new Point(false);
        }
        return new Point(RANDOM.nextBoolean());
    }
}

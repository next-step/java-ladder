package nextstep.ladder.pattern;

import nextstep.ladder.domain.Point;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private Random random = new Random();

    @Override
    public Point get() {
        return Point.of(random.nextBoolean());
    }
}

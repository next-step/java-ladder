package nextstep.ladder.factory;

import nextstep.ladder.domain.line.Point;

import java.util.Random;

public class PointFactory {

    private final Random random;

    public PointFactory() {
        this(new Random());
    }

    public PointFactory(Random random) {
        this.random = random;
    }

    public Point first() {
        return new Point(random.nextBoolean());
    }

    public Point next(Point point) {
        if (point.getValue()) {
            return new Point(false);
        }
        return new Point(random.nextBoolean());
    }
}

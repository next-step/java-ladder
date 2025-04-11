package nextstep.ladder.domain.line;

import java.util.Random;

public class PointFactory {

    private final Random random;

    public PointFactory() {
        this(new Random());
    }

    public PointFactory(Random random) {
        this.random = random;
    }

    public Point create(Point point) {
        if (point.getValue()) {
            return new Point(false);
        }
        return new Point(random.nextBoolean());
    }
}

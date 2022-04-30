package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.Random;

public final class RandomPointPainter implements PointPainter {

    private final Random random;

    private RandomPointPainter(Random random) {
        Assert.notNull(random, "random must not be null");
        this.random = random;
    }

    public static RandomPointPainter from(Random random) {
        return new RandomPointPainter(random);
    }

    @Override
    public Point point() {
        if (random.nextBoolean()) {
            return Point.connected();
        }
        return Point.disconnected();
    }
}

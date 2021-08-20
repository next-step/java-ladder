package nextstep.ladders.domain;

import java.util.Random;

public class RandomPointGenerateStrategy implements PointGenerateStrategy {

    private static final Random random = new Random();

    @Override
    public boolean next(final boolean previous) {
        boolean next = false;
        if (!previous) {
            next = random.nextBoolean();
        }
        return next;
    }
}

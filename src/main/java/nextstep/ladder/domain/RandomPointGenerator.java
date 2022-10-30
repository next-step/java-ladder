package nextstep.ladder.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPointGenerator implements PointGenerator {
    private final static ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @Override
    public boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}

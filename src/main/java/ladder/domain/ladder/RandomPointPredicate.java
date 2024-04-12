package ladder.domain.ladder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPointPredicate implements PointPredicate {

    private static final Random random = ThreadLocalRandom.current();

    @Override
    public boolean exists() {
        return random.nextBoolean();
    }
}

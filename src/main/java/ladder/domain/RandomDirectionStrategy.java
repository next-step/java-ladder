package ladder.domain;

import java.util.Random;

public class RandomDirectionStrategy extends DirectionStrategy {
    private static final Random random = new Random();

    @Override
    Direction get() {
        return get(random.nextBoolean());
    }
}

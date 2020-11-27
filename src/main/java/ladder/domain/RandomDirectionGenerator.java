package ladder.domain;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

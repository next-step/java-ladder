package ladder.domain;

import java.util.Random;

public class RandomDirectionGenerateStrategy implements DirectionGenerateStrategy {

    private static final Random RANDOM = new Random();
    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

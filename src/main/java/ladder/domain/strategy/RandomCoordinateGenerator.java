package ladder.domain.strategy;

import java.util.Random;

public class RandomCoordinateGenerator implements CoordinateGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

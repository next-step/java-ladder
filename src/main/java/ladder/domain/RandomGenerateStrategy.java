package ladder.domain;

import java.util.Random;

public class RandomGenerateStrategy implements GenerateStrategy {

    private static final Random RANDOM = new Random();
    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

package step2.domain;

import java.util.Random;

public class RandomGenerator implements BooleanGenerator {
    private final Random random = new Random();

    @Override
    public boolean nextBoolean() {
        return random.nextBoolean();
    }
}

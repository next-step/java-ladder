package ladder.domain.generator;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {
    private Random random = new Random();

    @Override
    public boolean generateValue() {
        return random.nextBoolean();
    }
}
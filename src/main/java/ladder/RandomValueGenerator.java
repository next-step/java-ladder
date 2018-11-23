package ladder;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {
    private static Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

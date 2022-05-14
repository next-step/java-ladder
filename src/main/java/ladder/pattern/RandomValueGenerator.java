package ladder.pattern;

import java.security.SecureRandom;
import java.util.Random;

public class RandomValueGenerator implements ValueGenerateStrategy {
    private static final Random random = new SecureRandom();

    @Override
    public boolean booleanGenerate() {
        return random.nextBoolean();
    }
}

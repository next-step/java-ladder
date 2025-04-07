package nextstep.generator;

import java.util.Random;

public class RandomNumberGenerator implements LineGenerator {
    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

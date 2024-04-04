package ladder.domain;

import java.util.Random;

public class RandomLineGenerator implements LineGeneratorStrategy {
    private static final Random random = new Random();

    @Override
    public boolean nextBoolean() {
        return random.nextBoolean();
    }
}

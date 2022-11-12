package nextstep.ladder.domain;

import java.util.Random;

public class RandomLineGenerationStrategy implements LineGenerationStrategy {
    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

package nextstep.ladder.domain;

import java.util.Random;

public class RandomLineGenerateStrategy implements LineGenerateStrategy {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

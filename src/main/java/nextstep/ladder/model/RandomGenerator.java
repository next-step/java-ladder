package nextstep.ladder.model;

import java.util.Random;

public final class RandomGenerator {
    private static final Random random = new Random();

    public boolean trueOrFalse() {
        return random.nextBoolean();
    }
}

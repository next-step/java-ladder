package ladder.domain.util;

import java.util.Random;

public class RightPointRandom implements RandomStrategy {
    private static final Random random = new Random();

    public boolean right() {
        return random.nextBoolean();
    }
}

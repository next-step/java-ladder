package ladder.domain.util;

import java.util.Random;

public class RightPointRandom {
    private static final Random random = new Random();

    public boolean right() {
        return random.nextBoolean();
    }
}

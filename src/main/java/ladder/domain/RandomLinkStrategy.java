package ladder.domain;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {
    private final Random random = RandomUtils.RANDOM;

    @Override
    public boolean get() {
        return random.nextBoolean();
    }
}

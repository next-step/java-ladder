package ladder.ladder.infrastructure;

import ladder.ladder.domain.LinkStrategy;
import ladder.ladder.util.RandomUtils;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {
    private final Random random = RandomUtils.RANDOM;

    @Override
    public boolean get() {
        return random.nextBoolean();
    }
}

package nextstep.ladder.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author han
 */
public class RandomStrategy implements LineStrategy {
    private static final Random random = ThreadLocalRandom.current();

    @Override
    public boolean random() {
        return random.nextBoolean();
    }
}

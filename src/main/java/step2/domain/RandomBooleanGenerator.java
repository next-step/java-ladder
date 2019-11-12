package step2.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomBooleanGenerator implements BooleanGenerator {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean next() {
        return random.nextBoolean();
    }
}

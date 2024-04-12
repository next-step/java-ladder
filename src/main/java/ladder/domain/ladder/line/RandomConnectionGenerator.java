package ladder.domain.ladder.line;

import java.util.concurrent.ThreadLocalRandom;

public class RandomConnectionGenerator implements ConnectionGenerator {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

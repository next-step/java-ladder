package nextstep.ladder.generator;

import java.util.Optional;
import java.util.Random;

public class LineRandomGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate(boolean prevBoolean) {
        return Optional.of(prevBoolean)
                .map(prev -> !prev && RANDOM.nextBoolean())
                .orElse(RANDOM.nextBoolean());
    }
}

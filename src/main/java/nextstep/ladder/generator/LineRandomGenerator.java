package nextstep.ladder.generator;

import java.util.Optional;
import java.util.Random;

public class LineRandomGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate(Boolean prevBoolean) {
        return Optional.ofNullable(prevBoolean)
                .filter(prev -> prev == Boolean.FALSE)
                .map((prev) -> RANDOM.nextBoolean())
                .orElse(Boolean.FALSE);

    }
}

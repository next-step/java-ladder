package nextstep.ladder.domain.strategy;

import java.util.Objects;
import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy {

    private final Random random;

    private RandomLineCreateStrategy(Random random) {
        validate(random);

        this.random = random;
    }

    private void validate(Random random) {
        if (Objects.isNull(random)) {
            throw new IllegalArgumentException("Random은 null이면 안된다");
        }
    }

    public static RandomLineCreateStrategy of(Random random) {
        return new RandomLineCreateStrategy(random);
    }

    @Override
    public boolean isCreatable() {
        return random.nextBoolean();
    }
}

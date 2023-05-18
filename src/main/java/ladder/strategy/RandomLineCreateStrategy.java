package ladder.strategy;

import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy {

    private final Random random;

    public RandomLineCreateStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean createLine() {
        return random.nextBoolean();
    }
}

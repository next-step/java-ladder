package ladder.strategy;

import java.util.Random;

public class AddLineStrategy implements LineStrategy {

    private final Random random;

    public AddLineStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

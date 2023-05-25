package ladder.domain.strategy;

import java.util.Random;

public class BooleanRandomGenerator implements GenerateStrategy {

    private final Random random = new Random();

    @Override
    public boolean makeLine() {
        return random.nextBoolean();
    }
}

package ladder.domain.strategy;

import java.util.Random;

public class BooleanRandomGeneratorStrategy implements GenerateStrategy {

    private final Random random = new Random();

    @Override
    public boolean generateBoolean() {
        return random.nextBoolean();
    }
}

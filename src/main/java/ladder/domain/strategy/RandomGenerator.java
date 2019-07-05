package ladder.domain.strategy;

import java.util.Random;

public class RandomGenerator implements GeneratorInterface {
    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }
}

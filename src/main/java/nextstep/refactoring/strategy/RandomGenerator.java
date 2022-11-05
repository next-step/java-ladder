package nextstep.refactoring.strategy;

import java.util.Random;

public class RandomGenerator implements BooleanGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

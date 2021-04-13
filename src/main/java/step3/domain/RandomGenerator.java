package step3.domain;

import java.util.Random;

public class RandomGenerator implements PositionGenerator {
    Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

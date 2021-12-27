package ladder.domain.rule;

import java.util.Random;

public class RandomGenerator implements PositionGenerator {

    private static Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

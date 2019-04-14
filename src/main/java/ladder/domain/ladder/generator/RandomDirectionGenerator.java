package ladder.domain.ladder.generator;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {
    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

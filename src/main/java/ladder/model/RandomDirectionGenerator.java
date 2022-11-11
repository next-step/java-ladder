package ladder.model;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

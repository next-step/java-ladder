package ladder.model;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM .nextBoolean();
    }
}

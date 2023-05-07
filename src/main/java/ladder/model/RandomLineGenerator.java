package ladder.model;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate(boolean hasPrevious) {
        if (hasPrevious) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}

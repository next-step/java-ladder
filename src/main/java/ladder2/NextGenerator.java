package ladder2;

import java.util.Random;

public class NextGenerator implements RandomGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }
}

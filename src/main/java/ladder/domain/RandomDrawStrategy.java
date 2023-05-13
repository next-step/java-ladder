package ladder.domain;

import java.util.Random;

public class RandomDrawStrategy implements DrawStrategy {
    private static final Random random = new Random();

    @Override
    public boolean draw() {
        return random.nextBoolean();
    }
}

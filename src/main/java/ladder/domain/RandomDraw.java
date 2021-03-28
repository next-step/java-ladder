package ladder.domain;

import java.util.Random;

public class RandomDraw implements DrawStrategy {

    private final Random random = new Random();

    @Override
    public boolean drawValue() {
        return random.nextBoolean();
    }
}

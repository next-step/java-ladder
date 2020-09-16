package ladder.domain;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {
    private static final Random random = new Random();

    @Override
    public boolean next() {
        return random.nextBoolean();
    }
}

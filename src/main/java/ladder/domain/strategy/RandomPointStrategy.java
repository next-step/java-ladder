package ladder.domain.strategy;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {
    private final Random random = new Random();

    @Override
    public boolean next() {
        return random.nextBoolean();
    }
}

package ladder.domain.ladder;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

package ladder.domain.generator;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {

        return random.nextBoolean();
    }
}

package nextstep.generator;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

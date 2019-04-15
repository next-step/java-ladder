package ladder.domain;

import java.util.Random;

public class BooleanGeneratorNormal implements BooleanGenerator {
    private static final Random random = new Random();

    @Override
    public boolean generatePoint() {
        return random.nextBoolean();
    }
}

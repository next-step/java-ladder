package ladder.domain.generator;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {

        return random.nextBoolean();
    }
}

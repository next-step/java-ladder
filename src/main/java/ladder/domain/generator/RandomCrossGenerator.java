package ladder.domain.generator;

import java.util.Random;

public class RandomCrossGenerator implements CrossGenerator {

    public static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

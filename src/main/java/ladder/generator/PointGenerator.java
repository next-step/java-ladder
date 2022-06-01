package ladder.generator;

import ladder.exception.NotSupportException;

import java.util.Random;

public class PointGenerator {

    private static final Random random = new Random();

    private PointGenerator() {
        throw new NotSupportException();
    }

    public static boolean generate() {
        return random.nextBoolean();
    }
}

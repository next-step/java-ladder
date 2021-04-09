package nextstep.ladder.generator;

import java.util.Random;

public class RandomValueGenerator {
    private static final Random random = new Random();

    public static boolean generatePoint() {
        return random.nextBoolean();
    }
}

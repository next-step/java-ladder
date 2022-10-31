package nextstep.step2.domain;

import java.util.Random;

public class RandomLineGenerator {
    private static final Random random = new Random();

    private RandomLineGenerator() {

    }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}

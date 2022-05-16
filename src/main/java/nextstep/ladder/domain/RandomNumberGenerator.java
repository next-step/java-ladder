package nextstep.ladder.domain;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int BOUND = 20;
    private static final Random random = new Random();

    public static int generate() {
        return random.nextInt(BOUND);
    }
}

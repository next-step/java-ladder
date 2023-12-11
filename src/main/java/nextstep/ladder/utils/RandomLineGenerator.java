package nextstep.ladder.utils;

import java.util.Random;

public class RandomLineGenerator {
    private static final Random random = new Random();

    public static boolean generateLine() {
        return random.nextBoolean();
    }
}

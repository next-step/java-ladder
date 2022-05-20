package nextstep.ladder.util;

import java.util.Random;

public class RandomBoolean {
    private static final Random RANDOM = new Random();

    private RandomBoolean() {
    }

    public static boolean trueOrFalse() {
        return RANDOM.nextBoolean();
    }
}

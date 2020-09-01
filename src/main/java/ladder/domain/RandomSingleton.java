package ladder.domain;

import java.util.Random;

public class RandomSingleton {

    private static final Random RANDOM_INSTANCE = new Random();

    private RandomSingleton() {}

    public static boolean nextBoolean() {
        return RANDOM_INSTANCE.nextBoolean();
    }
}

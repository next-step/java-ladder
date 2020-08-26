package ladder.domain;

import java.util.Random;

public class RandomSingleton {

    private final static Random RANDOM_INSTANCE = new Random();

    public static boolean nextBoolean() {
        return RANDOM_INSTANCE.nextBoolean();
    }
}

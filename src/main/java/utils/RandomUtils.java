package utils;

import java.util.Random;

public class RandomUtils {
    private final static Random RANDOM = new Random();

    public static int getZeroOrOne() {
        return RANDOM.nextDouble() >= 0.5 ? 1 : 0;
    }
}

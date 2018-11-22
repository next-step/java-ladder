package util;

import java.util.Random;

public abstract class RandomUtil {

    private final static Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }

}

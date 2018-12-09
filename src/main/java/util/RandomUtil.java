package util;

import domain.Level;

import java.util.Random;

public abstract class RandomUtil {

    private final static Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }

    public static boolean generate(final int weight) {

        if (weight == 0) {
            return false;
        }

        return RANDOM.nextInt(Level.MAXIMUM_WEIGHT) <= weight;
    }

}

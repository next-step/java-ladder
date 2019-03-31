package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random = new Random();

    public static Integer nextInt(int start, int end) {
        return random.nextInt((end + 1) - start) + start;
    }
}

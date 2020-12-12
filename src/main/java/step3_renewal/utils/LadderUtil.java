package step3_renewal.utils;

import java.util.Random;

public class LadderUtil {
    private static final Random RANDOM = new Random();

    public static boolean isLine() {
        return RANDOM.nextBoolean();
    }
}

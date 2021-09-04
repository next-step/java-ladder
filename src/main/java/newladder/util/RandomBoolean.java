package newladder.util;

import java.util.Random;

public class RandomBoolean {
    private static final Random rand = new Random();

    public static boolean random() {
        return rand.nextBoolean();
    }
}

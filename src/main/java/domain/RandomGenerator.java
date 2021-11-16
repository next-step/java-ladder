package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static List<Boolean> produceRandomFlags(int size) {
        boolean prev = false;
        List<Boolean> randomFlags = new ArrayList<>();

        for (int i=0; i < size; i++) {
            boolean current = produceRandomFlag(prev);
            prev = current;
            randomFlags.add(current);
        }

        return randomFlags;
    }

    private static boolean produceRandomFlag(boolean prev) {
        if (prev) {
            return false;
        }

        return random.nextBoolean();
    }
}

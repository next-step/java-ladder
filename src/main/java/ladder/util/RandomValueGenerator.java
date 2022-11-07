package ladder.util;

import java.util.Random;

public class RandomValueGenerator {
    private final static Random random = new Random();

    public RandomValueGenerator() {
        throw new UnsupportedOperationException("no instance available");
    }

    public static boolean generate(){
        return random.nextBoolean();
    }
}

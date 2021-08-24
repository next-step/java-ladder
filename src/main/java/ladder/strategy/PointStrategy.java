package ladder.strategy;

import java.util.Random;

public class PointStrategy {

    public static boolean generate(boolean previous) {
        if (previous) {
            return false;
        }
        return generateRandom();
    }

    public static boolean generateRandom() {
        return new Random().nextBoolean();
    }
}

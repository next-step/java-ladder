package ladder.model;

import java.util.Random;

public class PointGenerator {
    private static final Random RANDOM = new Random();

    public static Boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}

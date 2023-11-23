package ladder.domain;

import java.util.Random;

public class CoordinateGeneration {

    public static final Random RANDOM = new Random();

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }
}

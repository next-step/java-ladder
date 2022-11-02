package ladder.generator;

import java.util.Random;

public class PointGenerator {

    public static final Random random = new Random();

    public static boolean generatePoint() {
        return random.nextBoolean();
    }

}

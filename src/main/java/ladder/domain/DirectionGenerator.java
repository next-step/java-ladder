package ladder.domain;

import java.util.Random;

public class DirectionGenerator {

    private static Random random = new Random();

    public static boolean generateDirection() {
        return random.nextBoolean();
    }
}

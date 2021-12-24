package ladder_refactor.domain;

import java.util.Random;

public class LadderPointGenerator {

    private static final Random random;

    static {
        random = new Random();
    }

    public static boolean generatePoint() {
        return random.nextBoolean();
    }
}

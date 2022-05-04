package nextstep.step4.util;

import java.util.Random;

public class LadderPointGenerator {

    private static final Random random = new Random();

    public static boolean generateDirection() {
        return random.nextBoolean();
    }
}

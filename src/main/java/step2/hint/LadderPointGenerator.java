package step2.hint;

import java.util.Random;

public class LadderPointGenerator {
    private static Random random = new Random();

    public static boolean generatePoint() {
        return random.nextBoolean();
    }
}

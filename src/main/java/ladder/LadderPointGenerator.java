package ladder;

import java.util.concurrent.ThreadLocalRandom;

public class LadderPointGenerator {
    private static int MAX_BOUND = 100;
    private static int MAX_THRESHOLD = 50;

    public static boolean generatePoint() {
        int number = ThreadLocalRandom.current().nextInt(MAX_BOUND);
        return number > MAX_THRESHOLD;
    }
}

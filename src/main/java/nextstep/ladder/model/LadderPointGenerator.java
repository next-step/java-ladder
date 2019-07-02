package nextstep.ladder.model;

import java.util.Random;

public class LadderPointGenerator {
    private static Random random = new Random();

    LadderPointGenerator() {
        random = new Random();
    }

    public static boolean generatePoint() {
        return random.nextBoolean();
    }
}

package nextstep.ladder.step4;

import java.util.Random;

public class LadderPointGenerator {
    private static final Random RANDOM = new Random();

    private LadderPointGenerator() {
    }

    public static boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}

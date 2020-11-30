package nextstep.ladder.domain;

import java.util.Random;

public class LadderPointGenerator {
    private static final Random RANDOM = new Random();

    private LadderPointGenerator() {
    }

    public static boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}

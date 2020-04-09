package nextstep.ladder.domain.line;

import java.util.Random;

public class LadderPointGenerator {
    private static final Random random = new Random();

    public static boolean generatePoint() {
        return random.nextBoolean();
    }

    private LadderPointGenerator() {
    }
}

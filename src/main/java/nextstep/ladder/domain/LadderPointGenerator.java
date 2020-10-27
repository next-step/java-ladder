package nextstep.ladder.domain;

import java.util.Random;

public class LadderPointGenerator {
    public static final Random random = new Random();

    public static boolean generatePoint() {
        return random.nextBoolean();
    }
}

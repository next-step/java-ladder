package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointCreator {
    private static final Random random = new Random();

    private RandomPointCreator() {
    }

    public static boolean createPoint() {
        return random.nextBoolean();
    }
}

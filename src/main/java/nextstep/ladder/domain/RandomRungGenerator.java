package nextstep.ladder.domain;

import java.util.Random;

public class RandomRungGenerator {
    private static final Random RANDOM = new Random();

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }
}

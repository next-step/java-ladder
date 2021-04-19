package nextstep.ladder.util;

import java.util.Random;

public class PointGenerator {

    private static final Random RANDOM = new Random();

    private PointGenerator() {
    }

    public static boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}
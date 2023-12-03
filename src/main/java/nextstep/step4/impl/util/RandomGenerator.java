package nextstep.step4.impl.util;

import nextstep.step4.impl.Point;
import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();
    private RandomGenerator() {
    }

    public static boolean isCreate(Point point) {
        return random.nextBoolean() && isBeforeFalse(point);
    }

    private static boolean isBeforeFalse(final Point point) {
        return !point.current();
    }

    public static boolean generate() {
        return random.nextBoolean();
    }
}

package nextstep.mission.domain;

import java.util.Random;

public class RandomPoint {

    private static final Random DICE = new Random();

    private RandomPoint() {}

    public static boolean next(boolean value) {
        if (value) {
            return false;
        }

        return DICE.nextBoolean();
    }

    public static boolean next() {
        return next(false);
    }
}

package nextstep.mission.domain;

import java.util.Random;

public class RandomPoint {

    private static final Random DICE = new Random();

    private static boolean store;

    private RandomPoint() {}

    public static Point next(int index) {
        if (index == 0 || store) {
            store = false;
            return Point.of(false);
        }

        store = DICE.nextBoolean();
        return Point.of(store);
    }
}

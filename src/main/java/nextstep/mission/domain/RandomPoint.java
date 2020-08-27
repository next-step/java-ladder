package nextstep.mission.domain;

import java.util.Random;

public class RandomPoint {

    private static final Random DICE = new Random();

    private static boolean store;

    private RandomPoint() {}

    public static void reset() {
        store = DICE.nextBoolean();
    }

    public static boolean next() {
        if (store) {
            store = false;
            return false;
        }

        store = DICE.nextBoolean();

        return store;
    }
}

package nextstep.mission;

import java.util.Random;

public class RandomPoint {

    static final Random DICE = new Random();

    boolean store;

    public RandomPoint(boolean init) {
        store = init;
    }

    public boolean next() {
        if (store) {
            store = false;
            return false;
        }

        store = DICE.nextBoolean();

        return store;
    }
}

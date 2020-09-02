package nextstep.mission.domain;

import java.util.Random;

public class RandomPoint {

    private static final Random DICE = new Random();

    private RandomPoint() {}

    public static boolean next() {
        return DICE.nextBoolean();
    }
}

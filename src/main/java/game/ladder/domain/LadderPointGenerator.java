package game.ladder.domain;

import java.util.Random;

public class LadderPointGenerator {

    private static final Random RANDOM = new Random();

    public static boolean generatePoint() {
        return RANDOM.nextBoolean();
    }

}

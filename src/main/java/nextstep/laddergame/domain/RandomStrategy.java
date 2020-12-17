package nextstep.laddergame.domain;

import java.util.Random;

public class RandomStrategy {
    private static Random random = new Random();

    public static boolean isMovable() {
        return random.nextBoolean();
    }
}
package nextstep.laddergame.domain;

import java.util.Random;

public class RandomStrategy implements MovingStrategy{
    private static Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextBoolean();
    }
}
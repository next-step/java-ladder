package nextstep.ladder.domain.step.strategy;

import java.util.Random;

public class RandomMovement implements Movement {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_NUMBER = 10;

    @Override
    public boolean isMovable() {
        return new Random().nextInt(RANDOM_BOUND) >= MOVABLE_NUMBER;
    }
}

package ladder.strategy;

import java.util.Random;

public class RandomlyMovableStrategy implements MovableStrategy {
    private final Random random;

    public RandomlyMovableStrategy() {
        random = new Random();
    }

    @Override
    public boolean isMovable() {
        return random.nextBoolean();
    }
}

package ladder.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final static int RANDOM_RANGE = 2;
    private final Random random;

    public RandomMovingStrategy() {
        this.random = new Random();
    }

    public RandomMovingStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public boolean canMove() {
        return random.nextInt(RANDOM_RANGE) != 0;
    }
}

package ladder.strategy;

import java.util.Random;

public class RandomGeneratorStrategy implements GeneratorStrategy {
    private final Random random;

    public RandomGeneratorStrategy() {
        this.random = new Random();
    }

    public RandomGeneratorStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public boolean canMove() {
        return random.nextBoolean();
    }
}

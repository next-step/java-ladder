package strategy;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {
    private final static Random RANDOM_GENERATOR = new java.util.Random();
    private final static RandomPointStrategy randomPointStrategy;

    static {
        randomPointStrategy = new RandomPointStrategy();
    }

    private RandomPointStrategy() {}

    public static RandomPointStrategy of() {
        return randomPointStrategy;
    }

    @Override
    public boolean hasPoint() {
        return RANDOM_GENERATOR.nextBoolean();
    }
}

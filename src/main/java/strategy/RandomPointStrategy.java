package strategy;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {
    private final static Random RANDOM_GENERATOR = new java.util.Random();

    @Override
    public boolean hasPoint() {
        return RANDOM_GENERATOR.nextBoolean();
    }
}

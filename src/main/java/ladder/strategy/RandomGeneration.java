package ladder.strategy;

import ladder.constant.Point;

import java.util.Random;

public class RandomGeneration implements GenerationStrategy {
    
    private static final Random random = new Random();

    @Override
    public Point generatePoint() {
        return Point.valueOf(random.nextBoolean());
    }
}

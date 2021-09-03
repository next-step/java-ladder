package ladderrefactoring.strategy;

import java.util.Random;

public class RandomDirectionStrategy implements DirectionStrategy {

    private static final Random random = new Random();

    @Override
    public boolean create() {
        return random.nextBoolean();

    }
}

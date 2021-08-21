package ladder.domain;

import java.util.Random;

public class RandomDirectionStrategy implements DirectionStrategy {

    private final Random RANDOM = new Random();

    @Override
    public boolean move() {
        return RANDOM.nextBoolean();
    }
}

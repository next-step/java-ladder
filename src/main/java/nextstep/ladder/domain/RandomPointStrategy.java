package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {
    private final Random random;

    public RandomPointStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}


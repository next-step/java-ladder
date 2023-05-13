package nextstep.ladder.domain.util;

import java.util.Random;

public class RandomStrategy implements DrawStrategy {

    private Random random = new Random();

    public RandomStrategy(Random random) {
        this.random = random;
    }

    public RandomStrategy() {
    }

    @Override
    public boolean drawFirstPosition() {
        return random.nextBoolean();
    }

    @Override
    public boolean drawNextPosition(boolean previous) {
        if (previous) {
            return false;
        }

        return random.nextBoolean();
    }
}

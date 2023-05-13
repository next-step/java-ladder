package nextstep.ladder.domain.util;

import nextstep.ladder.domain.Step;

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
    public boolean drawNextPosition(Step step) {
        if (step.hasStep()) {
            return false;
        }

        return random.nextBoolean();
    }
}

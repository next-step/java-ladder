package nextstep.ladder.domain;

import java.util.Random;

public class RandomDrawStrategy implements DrawStrategy {
    private static final int FIRST_INDEX = 0;
    private static final int RANDOM_BOUND = 5;
    private static final int RANDOM_CONDITION = 2;
    private Random RANDOM = new Random();

    public RandomDrawStrategy(Random RANDOM) {
        this.RANDOM = RANDOM;
    }

    public RandomDrawStrategy() {
    }

    @Override
    public boolean draw(int index, boolean previous) {
        if (index == FIRST_INDEX || previous) {
            return false;
        }

        return RANDOM.nextInt(RANDOM_BOUND) >= RANDOM_CONDITION;
    }
}
package ladder.domain.strategy;

import java.util.Random;

public class RandomTrueCondition implements TrueCondition {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_UPPER_BOUND = 2;

    @Override
    public boolean isTrue() {
        return RANDOM.nextInt(RANDOM_NUMBER_UPPER_BOUND) == 1;
    }
}

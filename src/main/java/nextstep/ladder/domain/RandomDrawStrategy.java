package nextstep.ladder.domain;

import java.util.Random;

public class RandomDrawStrategy implements DrawStrategy {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 4;
    private static final int RANDOM_CONDITION = 1;

    @Override
    public boolean draw(boolean previous) {
        if (previous) {
            return false;
        }
        int randomValue = RANDOM.nextInt(RANDOM_BOUND);
        return randomValue >= RANDOM_CONDITION;
    }
}

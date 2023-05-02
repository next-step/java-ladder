package nextstep.ladder.domain;

import java.util.Random;

public class FirstDrawStrategy implements DrawStrategy {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 4;
    private static final int RANDOM_CONDITION = 2;

    @Override
    public boolean draw(boolean previous) {
        int randomValue = RANDOM.nextInt(RANDOM_BOUND);
        return randomValue >= RANDOM_CONDITION;
    }
}

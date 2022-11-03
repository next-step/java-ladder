package ladder.domain;

import java.util.Random;

public class RandomStickDecisionStrategy implements StickDecisionStrategy {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int CONDITION = 3;

    @Override
    public boolean isExists() {
        return RANDOM.nextInt(BOUND) > CONDITION;
    }
}

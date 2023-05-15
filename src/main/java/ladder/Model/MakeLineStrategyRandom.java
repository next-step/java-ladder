package ladder.Model;

import java.util.Random;

public class MakeLineStrategyRandom implements MakeLineStrategy {
    private static final int RANDOM_NUMBER_BOUND = 2;

    private final Random random = new Random();

    @Override
    public Boolean MakeLine(Boolean madeBefore) {
        if (madeBefore) {
            return false;
        }

        return random.nextInt(RANDOM_NUMBER_BOUND) == RANDOM_NUMBER_BOUND - 1;
    }
}

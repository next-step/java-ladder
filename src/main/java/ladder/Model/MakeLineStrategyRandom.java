package ladder.Model;

import java.util.Random;

public class MakeLineStrategyRandom implements MakeLineStrategy {
    private final Random random = new Random();

    @Override
    public Boolean makeLine(Boolean madeBefore) {
        if (madeBefore) {
            return false;
        }

        return random.nextBoolean();
    }
}

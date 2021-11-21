package nextstep.refactor_ladder.strategy;

import java.util.Random;

public class RandomLadderStrategy implements LadderStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

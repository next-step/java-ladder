package ladder.strategy;

import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy{
    private static final Random RANDOM = new Random();

    @Override
    public boolean create() {
        return RANDOM.nextBoolean();
    }
}

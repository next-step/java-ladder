package ladder.strategy;

import java.util.Random;

public class RandomGenerateStrategy implements LadderGenerateStrategy{
    private final Random RANDOM = new Random();

    @Override
    public boolean ladderGenerate() {
        return RANDOM.nextBoolean();
    }
}

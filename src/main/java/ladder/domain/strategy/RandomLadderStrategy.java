package ladder.domain.strategy;

import java.util.Random;

public class RandomLadderStrategy implements  LadderStrategy{

    private final Random random = new Random();

    @Override
    public boolean makeLine() {
        return random.nextBoolean();
    }
}

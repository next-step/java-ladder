package nextstep.ladder.strategy;

import java.util.Random;

public class RandomStrategy implements LiningStrategy {
    private final Random random = new Random();

    @Override
    public boolean canDrawLine() {
        return random.nextBoolean();
    }
}

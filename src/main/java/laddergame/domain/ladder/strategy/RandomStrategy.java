package laddergame.domain.ladder.strategy;

import java.util.Random;

public class RandomStrategy implements LinkStrategy {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 2;

    @Override
    public boolean linkable() {
        return RANDOM.nextInt(BOUND) % 2 == 0;
    }
}

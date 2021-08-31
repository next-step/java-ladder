package nextstep.ladder.strategy;

import java.util.Random;

public class RandomDrawLineStrategy implements DrawLineStrategy {

    private final Random random = new Random();

    @Override
    public boolean drawLine() {
        return random.nextBoolean();
    }
}

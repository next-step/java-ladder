package nextstep.ladder.strategy;

import java.util.Random;

public class RandomDrawLineStrategy implements DrawLineStrategy {

    private final Random random = new Random();

    @Override
    public boolean draw() {
        return random.nextBoolean();
    }
}

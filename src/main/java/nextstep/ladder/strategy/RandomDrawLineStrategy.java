package nextstep.ladder.strategy;

import java.util.Random;

public class RandomDrawLineStrategy implements DrawLineStrategy {

    Random random = new Random();

    @Override
    public boolean drawLine() {
        return random.nextBoolean();
    }
}

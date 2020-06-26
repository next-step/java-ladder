package nextstep.step4.domain.strategy;

import java.util.Random;

public class RandomDrawLineStrategy implements DrawLineStrategy {
    private Random random = new Random();

    @Override
    public boolean isDrawLine() {
        return random.nextBoolean();
    }
}

package nextstep.ladder.strategy;

import java.util.Random;

public class LadderLineStrategy implements LineStrategy{
    private static final Random RANDOM = new Random();

    @Override
    public boolean isLine() {
        return RANDOM.nextBoolean();
    }
}

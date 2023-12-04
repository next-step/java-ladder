package nextstep.ladder.model.strategy.line;

import java.util.Random;

public class RandomLineStrategyImpl implements LineStrategy {
    Random random = new Random();

    @Override
    public boolean drawLine() {
        return random.nextBoolean();
    }
}

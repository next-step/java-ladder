package nextstep.ladder.domain.line.strategy;

import java.util.Random;

public class HalfProbabilityLineCreateStrategy implements LineCreateStrategy{
    private final Random random = new Random();

    @Override
    public boolean create(boolean prevPoint) {
        if (prevPoint) {
            return false;
        }
        return random.nextBoolean();
    }
}

package nextstep.ladder.domain.line;

import java.util.Random;

public class HalfProbabilityLineCreateStrategy implements LineCreateStrategy{
    private final Random random = new Random();

    @Override
    public boolean createFirstPoint() {
        return random.nextBoolean();
    }

    @Override
    public boolean createNextPoint(boolean prevPoint) {
        if (prevPoint) {
            return false;
        }
        return random.nextBoolean();
    }
}

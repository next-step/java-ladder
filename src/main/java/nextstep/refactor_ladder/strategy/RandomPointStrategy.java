package nextstep.refactor_ladder.strategy;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean createPoint() {
        return RANDOM.nextBoolean();
    }
}

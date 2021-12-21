package nextstep.ladder.strategy;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generatePoint() {
        return RANDOM.nextBoolean();
    }
}

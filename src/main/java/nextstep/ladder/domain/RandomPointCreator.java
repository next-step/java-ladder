package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointCreator implements PointCreator {
    private static final Random random = new Random();

    @Override
    public boolean createPoint() {
        return random.nextBoolean();
    }
}

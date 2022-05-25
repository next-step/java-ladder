package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointCreationRule implements PointCreationRule {
    private static final Random random = new Random();

    @Override
    public boolean canCreate() {
        return random.nextBoolean();
    }
}

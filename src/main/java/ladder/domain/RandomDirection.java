package ladder.domain;

import java.util.Random;

public class RandomDirection implements DirectionCreator {
    private static final Random random = new Random();

    @Override
    public boolean create() {
        return random.nextBoolean();
    }
}

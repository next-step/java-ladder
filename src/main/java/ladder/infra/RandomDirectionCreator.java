package ladder.infra;

import ladder.domain.DirectionCreator;

import java.util.Random;

public class RandomDirectionCreator implements DirectionCreator {
    private static final Random random = new Random();

    @Override
    public boolean create() {
        return random.nextBoolean();
    }
}

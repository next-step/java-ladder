package ladder.domain.impl;

import java.util.Random;
import ladder.domain.engine.PointCreator;

public class MyPointCreator implements PointCreator {

    private static final Random random = new Random();

    @Override
    public boolean create() {
        return random.nextBoolean();
    }
}

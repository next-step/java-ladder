package ladder.util;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {

    private static final Random random = new Random();

    @Override
    public boolean point() {
        return random.nextBoolean();
    }

}

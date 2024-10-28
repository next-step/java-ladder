package nextstep.ladder.v2.model;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate(boolean prev) {
        boolean nextBoolean = RANDOM.nextBoolean();
        if (prev && nextBoolean) {
            return false;
        }
        return nextBoolean;
    }
}

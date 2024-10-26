package nextstep.ladder.v2.model;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private static final Random random = new Random();

    @Override
    public boolean generate(boolean prev) {
        // prev == true, cur == true -> false
        // else -> random.nextBoolean()

        boolean nextBoolean = random.nextBoolean();
        if (prev && nextBoolean) {
            return false;
        }
        return nextBoolean;
    }
}

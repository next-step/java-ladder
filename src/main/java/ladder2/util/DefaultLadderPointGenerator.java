package ladder2.util;

import java.util.Random;

public class DefaultLadderPointGenerator implements LadderPointGenerator {
    private static final Random random = new Random();

    public boolean generatePoint() {
        return random.nextBoolean();
    }
}

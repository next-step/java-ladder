package ladder.domain;

import java.util.Random;

public class LineRandom {
    private static final Random random = new Random();
    private static final int VALID_NUMBER_RANGE = 2;

    private LineRandom() {
    }

    public static int random() {
        return random.nextInt(VALID_NUMBER_RANGE);
    }

}

package ladder.domain.ladder;

import java.util.Random;

public class LineGeneratorRandomBoolean {
    private static final Random random = new Random();

    public static boolean isMovable() {
        return random.nextBoolean();
    }
}

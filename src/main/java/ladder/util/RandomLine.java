package ladder.util;

import java.util.Random;

public class RandomLine {
    private static final Random RANDOM = new Random();

    public boolean create() {
        return RANDOM.nextBoolean();
    }
}

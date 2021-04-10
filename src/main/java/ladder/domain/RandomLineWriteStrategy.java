package ladder.domain;

import java.util.Random;

public class RandomLineWriteStrategy implements LineWriteStrategy {

    private static final int WRITABLE_MAX_NUMBER = 2;
    private static final int WRITABLE_NUMBER = 1;

    private final Random random = new Random();

    @Override
    public boolean write() {
        return random.nextInt(WRITABLE_MAX_NUMBER) == WRITABLE_NUMBER;
    }

}

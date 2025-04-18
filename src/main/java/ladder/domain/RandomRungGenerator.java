package ladder.domain;

import java.util.Random;

public class RandomRungGenerator implements RungGenerator {
    public static final Random random = new Random();

    @Override
    public boolean isConnected() {
        return random.nextBoolean();
    }
}

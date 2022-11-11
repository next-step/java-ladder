package laddergame;

import java.util.Random;

public class RandomStateGenerator implements Generator {
    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

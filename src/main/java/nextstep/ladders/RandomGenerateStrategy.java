package nextstep.ladders;

import java.util.Random;

public class RandomGenerateStrategy implements Generator {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
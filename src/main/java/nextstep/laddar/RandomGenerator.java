package nextstep.laddar;

import java.util.Random;

public class RandomGenerator implements BooleanGenerator {

    private final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

package nextstep.step2.generator;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private static final Random random = new Random();

    @Override
    public boolean generator() {
        return random.nextBoolean();
    }
}

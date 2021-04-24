package ladder.service;

import java.util.Random;

public class RandomBooleanGenerator implements RandomBoolean {
    @Override
    public boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}

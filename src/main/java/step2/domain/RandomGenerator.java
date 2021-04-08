package step2.domain;

import java.util.Random;

public class RandomGenerator implements NumberGenerator{

    @Override
    public boolean number() {
        return new Random().nextBoolean();
    }
}

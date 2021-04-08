package step2;

import java.util.Random;

public class RandomGenerator implements NumberGenerator{

    @Override
    public boolean number() {
        return new Random().nextBoolean();
    }
}

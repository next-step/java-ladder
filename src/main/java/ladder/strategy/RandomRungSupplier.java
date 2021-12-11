package ladder.strategy;

import java.util.Random;

public class RandomRungSupplier implements MakeRungStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean test() {
        return RANDOM.nextBoolean();
    }

}

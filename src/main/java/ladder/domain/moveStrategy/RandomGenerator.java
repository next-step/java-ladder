package ladder.domain.moveStrategy;

import java.util.Random;

public class RandomGenerator implements Shift{

    private static final Random random = new Random();

    @Override
    public boolean next() {
        return random.nextBoolean();
    }
}

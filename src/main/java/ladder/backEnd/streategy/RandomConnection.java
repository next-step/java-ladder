package ladder.backEnd.streategy;

import java.util.Random;

public class RandomConnection implements ConnectionStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean connect() {
        return RANDOM.nextBoolean();
    }
}

package ladder.domain;

import java.util.Random;

public class RandomConnectionStrategy implements ConnectionStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean connect() {
        return RANDOM.nextBoolean();
    }

}

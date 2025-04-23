package nextstep.ladder.domain;

import java.util.Random;

public class RandomConnectionStrategy implements ConnectionStrategy {
    private final Random random;

    public RandomConnectionStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean connect() {
        return random.nextBoolean();
    }
}

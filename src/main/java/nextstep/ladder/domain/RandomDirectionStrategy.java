package nextstep.ladder.domain;

import java.util.Random;

public class RandomDirectionStrategy implements DirectionStrategy {

    private Random random = new Random();

    @Override
    public boolean next() {
        return random.nextBoolean();
    }
}

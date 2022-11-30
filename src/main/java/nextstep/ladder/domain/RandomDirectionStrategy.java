package nextstep.ladder.domain;

import java.util.Random;

public class RandomDirectionStrategy implements DirectionStrategy {

    private final Random random = new Random();

    @Override
    public boolean isRight() {
        return random.nextBoolean();
    }
}

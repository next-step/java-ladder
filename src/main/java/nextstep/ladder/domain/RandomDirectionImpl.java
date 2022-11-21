package nextstep.ladder.domain;

import java.util.Random;

public class RandomDirectionImpl implements DirectionStrategy {

    @Override
    public boolean isRight() {
        Random random = new Random();
        return random.nextBoolean();
    }
}

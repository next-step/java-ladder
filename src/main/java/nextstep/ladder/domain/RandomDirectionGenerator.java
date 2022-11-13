package nextstep.ladder.domain;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}

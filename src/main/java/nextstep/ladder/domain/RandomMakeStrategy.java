package nextstep.ladder.domain;

import java.util.Random;

public class RandomMakeStrategy implements LineMakeStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean canMake() {
        return RANDOM.nextBoolean();
    }
}

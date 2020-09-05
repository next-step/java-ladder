package nextstep.ladder.domain;

import java.util.Random;

public class RightPointRandomStrategy implements RightPointStrategy {

    private static final Random random = new Random();

    @Override
    public boolean right() {
        return random.nextBoolean();
    }
}

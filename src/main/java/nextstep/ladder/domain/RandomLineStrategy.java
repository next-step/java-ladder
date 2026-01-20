package nextstep.ladder.domain;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

package nextstep.ladder.domain;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean draw() {
        return RANDOM.nextBoolean();
    }
}

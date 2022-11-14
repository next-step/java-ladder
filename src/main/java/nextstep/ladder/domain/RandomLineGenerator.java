package nextstep.ladder.domain;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public Boolean generate() {
        return RANDOM.nextBoolean();
    }
}

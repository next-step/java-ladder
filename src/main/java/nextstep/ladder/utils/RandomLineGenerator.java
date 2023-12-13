package nextstep.ladder.utils;

import nextstep.ladder.domain.LineGenerator;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    private static final Random random = new Random();

    public boolean generateLine() {
        return random.nextBoolean();
    }
}

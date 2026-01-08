package nextstep.ladder.generator;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    private final static Random random = new Random();

    @Override
    public boolean generate(boolean prev) {
        return !prev && random.nextBoolean();
    }
}

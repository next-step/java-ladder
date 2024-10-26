package nextstep.ladder.domain.direction;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private static final int RANDOM_BOUND = 2;
    private static final int VALUE_FOR_LINE = 1;
    private static final Random RANDOM = new Random();

    private static final RandomLineGenerator INSTANCE = new RandomLineGenerator();

    public static RandomLineGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean generate(boolean before) {
        return !before && RANDOM.nextInt(RANDOM_BOUND) == VALUE_FOR_LINE;
    }
}

package nextstep.ladder.domain.direction;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private static final int RANDOM_BOUND = 2;
    private static final int VALUE_FOR_LINE = 1;
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate(boolean before) {
        return !before && RANDOM.nextInt(RANDOM_BOUND) == VALUE_FOR_LINE;
    }
}

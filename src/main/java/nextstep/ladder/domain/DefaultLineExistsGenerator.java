package nextstep.ladder.domain;

import java.util.Random;

public class DefaultLineExistsGenerator extends LineExistsGenerator {

    private static final Random RANDOM = new Random();

    public boolean generate(final boolean prev) {
        if (prev) {
            return false;
        }

        return RANDOM.nextBoolean();
    }
}

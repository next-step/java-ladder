package nextstep.ladder.domain.common;

import java.util.Random;

public class RightDirectionGenerator extends DirectionGenerator {

    private static final Random RANDOM = new Random();

    public boolean generate(final boolean prev) {
        if (prev) {
            return false;
        }

        return RANDOM.nextBoolean();
    }
}

package nextstep.ladder.domain;

import java.util.Random;

public class ConnectionCreationStrategyImpl implements ConnectionCreationStrategy {
    private static final Random random = new Random();
    public static final int BOUND = 10;
    public static final int LIMIT = 2;
    public static final int FIRST = 5;

    @Override
    public boolean isAble(int point) {
        if (point == 0) {
            return random.nextInt(BOUND) > FIRST;
        }

        return random.nextInt(BOUND) > LIMIT;
    }
}

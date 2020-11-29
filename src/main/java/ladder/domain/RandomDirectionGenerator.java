package ladder.domain;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public Direction generateFirst() {
        return Direction.valueOf(Boolean.FALSE, RANDOM.nextBoolean());
    }

    @Override
    public Direction generateNext(final Direction beforeDirection) {
        if (beforeDirection.hasRight()) {
            return Direction.valueOf(Boolean.TRUE, Boolean.FALSE);
        }
        return Direction.valueOf(Boolean.FALSE, RANDOM.nextBoolean());
    }
}

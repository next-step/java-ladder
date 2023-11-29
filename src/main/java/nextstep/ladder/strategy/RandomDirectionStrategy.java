package nextstep.ladder.strategy;

import nextstep.ladder.domain.Direction;

import java.util.Random;

public class RandomDirectionStrategy implements DirectionStrategy {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 2;

    @Override
    public Direction direction() {
        final int random = RANDOM.nextInt(BOUND);
        return Direction.of(random);
    }
}

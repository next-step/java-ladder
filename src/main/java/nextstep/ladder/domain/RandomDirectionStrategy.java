package nextstep.ladder.domain;

import java.util.Random;

public class RandomDirectionStrategy implements DirectionStrategy {
    private static final int DIRECTION_BOUND = 2;
    private Random random = new Random();

    @Override
    public Direction getStartDirection() {
        return Direction.from(getRandomDirectionNumber());
    }

    @Override
    public Direction getNextDirection() {
        return Direction.from(getRandomDirectionNumber());
    }

    @Override
    public Direction getEndDirection() {
        return null;
    }

    private int getRandomDirectionNumber() {
        return random.nextInt(DIRECTION_BOUND);
    }

}
//() -> random.nextInt(DIRECTION_BOUND)
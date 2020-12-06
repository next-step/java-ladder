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
    public Direction getNextDirection(Direction direction) {
        if(direction == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.from(getRandomDirectionNumber());
    }

    @Override
    public Direction getEndDirection(Direction direction) {
        if(direction == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.FORWARD;
    }

    private int getRandomDirectionNumber() {
        return random.nextInt(DIRECTION_BOUND);
    }

}

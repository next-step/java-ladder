package nextstep.ladder.strategy;

import nextstep.ladder.domain.Direction;

import java.util.Random;

public class RandomDirectionStrategy implements DirectionStrategy {
    private static final Random random = new Random();

    @Override
    public boolean isConnectable() {
        return random.nextBoolean();
    }

    @Override
    public Direction createFirstDirection() {
        if (isConnectable()) {
            return new Direction(false, true);
        }

        return new Direction(false, false);
    }

    @Override
    public Direction createNextDirection(Direction prev) {
        if (isConnectable()) {
            return new Direction(prev.rightSide(), true);
        }

        return new Direction(prev.rightSide(), false);
    }
}

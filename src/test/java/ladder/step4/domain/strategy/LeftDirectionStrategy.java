package ladder.step4.domain.strategy;

import ladder.step4.domain.Direction;

public class LeftDirectionStrategy implements DirectionStrategy {

    private static final DirectionStrategy instance = new LeftDirectionStrategy();

    private LeftDirectionStrategy() {}

    @Override
    public Direction createBody(Direction prev) {
        return Direction.LEFT;
    }

    @Override
    public Direction createTail(Direction prev) {
        return Direction.LEFT;
    }

    public static DirectionStrategy getInstance () {
        return instance;
    }
}

package ladder.step4.domain.strategy;

import ladder.step4.domain.Direction;

public class RightDirectionStrategy implements DirectionStrategy {

    private static final DirectionStrategy instance = new RightDirectionStrategy();

    private RightDirectionStrategy() {}

    @Override
    public Direction createBody(Direction prev) {
        return Direction.RIGHT;
    }

    @Override
    public Direction createTail(Direction prev) {
        return Direction.RIGHT;
    }

    public static DirectionStrategy getInstance () {
        return instance;
    }
}

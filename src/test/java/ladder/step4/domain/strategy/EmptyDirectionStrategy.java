package ladder.step4.domain.strategy;

import ladder.step4.domain.Direction;

public class EmptyDirectionStrategy implements DirectionStrategy {

    private static final DirectionStrategy instance = new EmptyDirectionStrategy();

    private EmptyDirectionStrategy() {}

    @Override
    public Direction createBody(Direction prev) {
        return Direction.EMPTY;
    }

    @Override
    public Direction createTail(Direction prev) {
        return Direction.EMPTY;
    }

    public static DirectionStrategy getInstance () {
        return instance;
    }
}

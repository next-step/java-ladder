package nextstep.ladder.strategy;

import nextstep.ladder.domain.Direction;

public interface DirectionStrategy {
    boolean isConnectable();

    Direction createFirstDirection();

    Direction createNextDirection(Direction prev);
}

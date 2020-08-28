package step2.domain.direction.strategy;

import step2.domain.direction.Direction;

public interface DirectionGenerateStrategy {

	Direction getNextDirection(Direction previous);

	Direction getDirectionToStart();

	Direction getDirectionToEnd(Direction previous);
}

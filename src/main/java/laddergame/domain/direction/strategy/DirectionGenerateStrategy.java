package laddergame.domain.direction.strategy;

import laddergame.domain.direction.Direction;

import java.util.function.Predicate;

public interface DirectionGenerateStrategy {

	Direction getNextDirection(Direction previous);

	Direction getDirectionToStart();

	Direction getDirectionToEnd(Direction previous);
}

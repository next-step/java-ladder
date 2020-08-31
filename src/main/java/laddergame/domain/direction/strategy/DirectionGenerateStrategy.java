package laddergame.domain.direction.strategy;

import laddergame.domain.direction.Direction;

import java.util.function.Predicate;

public interface DirectionGenerateStrategy {

	Direction getNextDirection(Direction previous);

	Direction getDirectionToStart();

	Direction getDirectionToEnd(Direction previous);

	default Predicate<Direction> predicateNotLeft() {
		return direction -> direction != Direction.LEFT;
	}

	default Predicate<Direction> predicateNotRight() {
		return direction -> direction != Direction.RIGHT;
	}

	default Predicate<Direction> validateByNextPoint(Direction now) {
		if(now == Direction.RIGHT) {
			return direction -> direction == Direction.LEFT;
		}
		return direction -> direction != Direction.LEFT;
	}
}

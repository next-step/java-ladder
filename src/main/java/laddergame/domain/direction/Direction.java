package laddergame.domain.direction;

import laddergame.domain.Coordinate;

import java.util.function.Function;

public enum Direction {

	LEFT(Coordinate::decreaseCoordinate),
	RIGHT(Coordinate::increaseCoordinate),
	DOWN(Coordinate::keepCoordinate);

	private final Function<Coordinate, Coordinate> computeNextCoordinate;

	Direction(Function<Coordinate, Coordinate> computeNextCoordinate) {
		this.computeNextCoordinate = computeNextCoordinate;
	}

	public Coordinate getNextCoordinate(Coordinate coordinate) {
		return computeNextCoordinate.apply(coordinate);
	}
}

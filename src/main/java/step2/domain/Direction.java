package step2.domain;

import java.util.function.Function;

public enum Direction {

	LEFT(integer -> integer - 1),
	RIGHT(integer -> integer + 1),
	DOWN(integer -> integer);

	private Function<Integer, Integer> computeNextCoordinate;

	Direction(Function<Integer, Integer> computeNextCoordinate) {
		this.computeNextCoordinate = computeNextCoordinate;
	}

	public Integer getNextCoordinate(Integer coordinate) {
		return computeNextCoordinate.apply(coordinate);
	}
}

package ladder.type;

import java.util.function.BiFunction;

import ladder.domain.Points;

public enum DirectionType {

	RIGHT((index, points) -> {
		if (points.isRight(index)) {
			return index + 1;
		}
		return index;
	}),
	LEFT_OR_RIGHT((index, points) -> {
		if (points.isLeft(index)) {
			return index - 1;
		}
		if (points.isRight(index)) {
			return index + 1;
		}
		return index;
	}),
	LEFT((index, points) -> {
		if (points.isLeft(index)) {
			return index - 1;
		}
		return index;
	});

	private final BiFunction<Integer, Points, Integer> operator;

	DirectionType(BiFunction<Integer, Points, Integer> operator) {
		this.operator = operator;
	}

	public static DirectionType of(int index, int pointsSize) {
		if (index == 0) {
			return RIGHT;
		}
		if (index < pointsSize) {
			return LEFT_OR_RIGHT;
		}
		return LEFT;
	}

	public int nextIndex(int index, Points points) {
		return operator.apply(index, points);
	}
}

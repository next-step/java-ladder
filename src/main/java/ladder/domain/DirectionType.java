package ladder.domain;

import java.util.function.Function;

public enum DirectionType {

	LEFT(i -> i - 1),
	DOWN(i -> i),
	RIGHT(i -> i + 1);

	private final Function<Integer, Integer> move;

	DirectionType(Function<Integer, Integer> move) {
		this.move = move;
	}

	public int move(int index) {
		return move.apply(index);
	}
}

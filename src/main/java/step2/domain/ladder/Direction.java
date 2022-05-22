package step2.domain.ladder;

import java.util.function.IntUnaryOperator;

public enum Direction {

	LEFT(index -> index - 1),
	STRAIGHT(index -> index),
	RIGHT(index -> index + 1);

	private final IntUnaryOperator nextLineIndexCalculator;

	Direction(IntUnaryOperator nextLineIndexCalculator) {
		this.nextLineIndexCalculator = nextLineIndexCalculator;
	}

	public int nextIndex(int playerIndex) {
		return this.nextLineIndexCalculator.applyAsInt(playerIndex);
	}
}

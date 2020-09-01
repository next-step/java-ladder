package ladder.domain.playing;

import java.util.function.UnaryOperator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Direction {
	LEFT(width -> width - 1),
	RIGHT(width -> width + 1),
	NONE(width -> width);

	private final UnaryOperator<Integer> movingOperator;

	public int move(int width) {
		return movingOperator.apply(width);
	}
}

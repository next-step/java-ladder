package ladder.model;

import java.util.Arrays;
import java.util.function.Function;

import ladder.message.ErrorMessage;

public enum Direction {
	LEFT(true, false, (position) -> position - 1),
	RIGHT(false, true, (position) -> position + 1),
	NONE(false, false, (position) -> position);

	private final boolean left;
	private final boolean right;
	private final Function<Integer, Integer> expression;

	Direction(boolean left, boolean right,
		Function<Integer, Integer> expression) {
		this.left = left;
		this.right = right;
		this.expression = expression;
	}

	public static int movePosition(boolean left, boolean right, int position) {
		return getExpression(left, right).expression.apply(position);
	}

	private static Direction getExpression(boolean left, boolean right) {
		return Arrays.stream(values())
			.filter(move -> move.left == left && move.right == right)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_MATCH_MOVE_ERROR_MESSAGE));
	}
}

package laddergame2.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.Arrays;

public enum Direction {

	LEFT(TRUE, FALSE),
	STRAIGHT(FALSE, FALSE),
	RIGHT(FALSE, TRUE);

	private boolean left;
	private boolean right;

	Direction(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}

	public static Direction of(boolean left, boolean right) {
		if (left && right) {
			throw new IllegalStateException("모든 방향으로 선을 가질 수 없습니다.");
		}

		return Arrays.stream(Direction.values())
				.filter(direction -> (direction.left && left) || (direction.right && right))
				.findFirst()
				.orElse(STRAIGHT);
	}

	public static Direction first(boolean right) {
		return of(false, right);
	}

	public Direction next() {
		if (right) {
			return next(FALSE);
		}
		return next(RandomGenerator.generate());
	}

	public Direction next(boolean nextRight) {
		return Direction.of(right, nextRight);
	}

	public Direction last() {
		return of(right, FALSE);
	}
}

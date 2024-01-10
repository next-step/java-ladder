package ladder.domain;

public enum Direction {
	LEFT(true, false, -1),
	RIGHT(false, true, 1),
	PASS(false, false, 0);

	private final boolean left;
	private final boolean right;
	private final int move;

	Direction(final boolean left, final boolean right, final int move) {
		this.left = left;
		this.right = right;
		this.move = move;
	}

	private static Direction of(final boolean left, final boolean right) {
		if (left) {
			return LEFT;
		}
		if (right) {
			return RIGHT;
		}

		return PASS;
	}

	public static Direction first(final boolean right) {
		return Direction.of(false, right);
	}

	public Direction end() {
		return Direction.of(this.right, false);
	}

	public Direction next(final boolean right) {
		return Direction.of(this.right, right);
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public int move() {
		return move;
	}
}

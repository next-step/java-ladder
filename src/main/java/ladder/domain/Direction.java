package ladder.domain;

import java.util.Random;

public enum Direction {
	RIGHT(false, true),
	LEFT(true, false),
	PASS(false, false);

	private static final Random random = new Random();
	private static final String BLANK_FORMAT = "     ";
	private static final String LINE_FORMAT = "-----";

	boolean left;
	boolean right;

	Direction(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}

	public static Direction of(boolean left, boolean right) {
		if (left && right) {
			throw new IllegalArgumentException("정상적인 사다리가 아닙니다.");
		}
		if (!left && right) {
			return Direction.RIGHT;
		}
		if (left && !right) {
			return Direction.LEFT;
		}
		if (!left && !right) {
			return Direction.PASS;
		}
		throw new IllegalArgumentException("정상적인 사다리가 아닙니다.");
	}

	public static Direction first(boolean right) {
		return Direction.of(false, right);
	}

	public static Direction first() {
		return Direction.of(false, random.nextBoolean());
	}

	public Direction next() {
		if (this.right) {
			return Direction.of(this.right, false);
		}
		return Direction.of(false, random.nextBoolean());
	}

	public Direction last() {
		return Direction.of(this.right, false);
	}

	public Position move(Position position) {
		if (this.right) {
			return position.increase();
		}
		if (this.left) {
			return position.decrease();
		}
		return position;
	}

	public String isLine() {
		return this.right ? LINE_FORMAT : BLANK_FORMAT;
	}

}

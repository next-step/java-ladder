package nextstep.ladder.domain.direction;

public enum Direction {

	RIGHT(false, true),
	LEFT(true, false),
	STAY(false, false);

	private final boolean left;
	private final boolean right;

	Direction(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}

	public static Direction of(boolean left, boolean right) {
		if (left && right) {
			throw new IllegalArgumentException("only left or right one direction can be specified.");
		}
		if (left && ! right) {
			return Direction.LEFT;
		}
		if (! left && right) {
			return Direction.RIGHT;
		}
		if (! left && ! right) {
			return Direction.STAY;
		}
		throw new IllegalArgumentException("something went wrong.");
	}

	public static Direction first(boolean isConnectedToNextPoint) {
		if (isConnectedToNextPoint) {
			return Direction.RIGHT;
		}
		return Direction.STAY;
	}

	public static Direction last(boolean isConnectedToBeforePoint) {
		if (isConnectedToBeforePoint) {
			return Direction.LEFT;
		}
		return Direction.STAY;
	}

	public Direction next(boolean isNextRight) {
		if (this.right) {
			return Direction.LEFT;
		}
		if (isNextRight) {
			return Direction.RIGHT;
		}
		return Direction.STAY;
	}
}

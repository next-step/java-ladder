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
}

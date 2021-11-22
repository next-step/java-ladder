package nextstep.ladder.domain;

public enum Direction {
	LEFT(-1),
	HOLD(0),
	RIGHT(1);

	private final int move;

	private static final String INVALID_MESSAGE = "left, right 두개 모두 존재할수 없습니다.";

	Direction(int move) {
		this.move = move;
	}

	public static Direction create(boolean left, boolean right) {
		if (left && right) {
			throw new IllegalArgumentException(INVALID_MESSAGE);
		}
		if (left) {
			return Direction.LEFT;
		}
		if (right) {
			return Direction.RIGHT;
		}
		return Direction.HOLD;
	}

	public int move(int index) {
		return index + move;
	}
}

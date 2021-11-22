package nextstep.ladder.domain;

public enum Direction {
	LEFT(-1),
	HOLD(0),
	RIGHT(1);

	private final int move;

	private static final String INVALID_MESSAGE = "left, right 두개 모두 존재할수 없습니다.";
	private static final int MOVE_LEFT = -1;
	private static final int MOVE_RIGHT = 1;

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

	public boolean isLeft() {
		return move == MOVE_LEFT;
	}

	public boolean isRight() {
		return move == MOVE_RIGHT;
	}

	public int move(int index) {
		return index + move;
	}
}

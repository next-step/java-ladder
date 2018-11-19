package domain.point;

/**
 * Created by hspark on 19/11/2018.
 */
public enum Direction {
	LEFT,
	RIGHT,
	NONE;

	public static Direction first(boolean isDrawn) {
		if (isDrawn) {
			return RIGHT;
		}
		return NONE;
	}

	public Direction next(boolean isDrawn) {
		if (this == RIGHT) {
			return LEFT;
		}
		if (isDrawn) {
			return RIGHT;
		}
		return NONE;
	}

	public Direction last() {
		if (this == RIGHT) {
			return LEFT;
		}
		return NONE;
	}

	public boolean isLeft() {
		return this == LEFT;
	}

	public boolean isRight() {
		return this == RIGHT;
	}
}

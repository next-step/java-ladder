package ladder.domain;

public class Point {
	private static final String POINT_ERROR_MSG = "Point에 연속된 True 값이 올 수 없습니다.";

	private final boolean left;
	private final boolean current;

	private Point(boolean left, boolean current) {
		if (left && current) {
			throw new IllegalArgumentException(POINT_ERROR_MSG);
		}
		this.left = left;
		this.current = current;
	}

	public static Point first(boolean current) {
		return new Point(false, current);
	}

	public Point next(boolean current) {
		return new Point(this.current, current);
	}

	public Point last() {
		return new Point(this.current, false);
	}

	public boolean current() {
		return current;
	}

	public Direction move() {
		if (left) {
			return Direction.LEFT;
		}
		if (current) {
			return Direction.RIGHT;
		}
		return Direction.PASS;
	}
}

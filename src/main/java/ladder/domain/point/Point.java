package ladder.domain.point;

import ladder.domain.direction.Direction;

public class Point {

	private int position;
	private Direction direction;

	public Point(int position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public static Point first(boolean isRight) {
		return new Point(0, Direction.first(isRight));
	}

	public Point next(boolean isNextRight) {
		return new Point(position + 1, direction.next(isNextRight));
	}

	public Point last() {
		return new Point(position + 1, direction.next(false));
	}

	public int pass() {
		return direction.pass(position);
	}

	public boolean isConnectedToNextPoint() {
		return direction == Direction.RIGHT;
	}
}

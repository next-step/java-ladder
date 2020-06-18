package ladder.domain.point;

import ladder.domain.direction.Direction;

public class Point {

	@Deprecated
	private boolean connectedToNextPoint;

	private int position;
	private Direction direction;

	@Deprecated
	private Point(boolean connectedToNextPoint) {
		this.connectedToNextPoint = connectedToNextPoint;
	}

	public Point(int position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	@Deprecated
	public static Point of(boolean connectedToNextPoint) {
		return new Point(connectedToNextPoint);
	}

	public static Point first(boolean isRight) {
		return new Point(0, Direction.first(isRight));
	}

	public Point next(boolean isNextRight) {
		return new Point(position + 1, direction.next(isNextRight));
	}

	public int pass() {
		return direction.pass(position);
	}

	@Deprecated
	public boolean isConnectedToNextPoint() {
		return connectedToNextPoint;
	}
}

package nextstep.ladder.domain.point;

import nextstep.ladder.domain.direction.Direction;

public class Point {

	private Direction direction;

	private Point(Direction direction) {
		this.direction = direction;
	}

	public static Point ofPoint(Direction direction) {
		return new Point(direction);
	}

	public boolean canMoveRight() {
		return direction == Direction.RIGHT;
	}

	public boolean canMoveLeft() {
		return direction == Direction.LEFT;
	}

	public Point last(Direction direction) {
		return new Point(Direction.last(direction));
	}

	public Point next(boolean isConnectedToNextPoint) {
		return new Point(direction.next(isConnectedToNextPoint));
	}

	public Direction getDirection() {
		return direction;
	}
}

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

	public Point last(boolean isConnectedToBeforePoint) {
		return new Point(Direction.last(isConnectedToBeforePoint));
	}

	public Point next(boolean isConnectedToNextPoint) {
		return new Point(direction.next(isConnectedToNextPoint));
	}
}

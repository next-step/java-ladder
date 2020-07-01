package nextstep.ladder.domain.point;

import nextstep.ladder.domain.direction.Direction;

public class Point {

	private boolean isConnectedToNextPoint;
	private Direction direction;

	private Point(boolean isConnectedToNextPoint) {
		this.isConnectedToNextPoint = isConnectedToNextPoint;
	}

	public static Point ofPoint(boolean isConnectedToNextPoint) {
		return new Point(isConnectedToNextPoint);
	}

	private Point(Direction direction) {
		this.direction = direction;
	}

	public static Point ofPoint(Direction direction) {
		return new Point(direction);
	}

	public void validateNotConnectedIfLastPoint() {
		if (isConnectedToNextPoint) {
			throw new IllegalArgumentException("last point should not be connected to the next point.");
		}
	}

	public boolean isConnectedToNextPoint() {
		return direction == Direction.RIGHT;
	}

	public Point last(boolean isConnectedToBeforePoint) {
		return new Point(Direction.last(isConnectedToBeforePoint));
	}

	public Point next(boolean isConnectedToNextPoint) {
		return new Point(direction.next(isConnectedToNextPoint));
	}
}

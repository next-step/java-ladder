package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

	private final Direction direction;

	public Point(Direction direction) {
		this.direction = direction;
	}

	public static Point first(boolean isRightward) {
		if (isRightward) {
			return new Point(Direction.RIGHT);
		}
		return new Point(Direction.STRAIGHT);
	}

	public static Point next(Point previous, boolean isRightward) {
		if (previous.direction.isRight()) {
			return new Point(Direction.LEFT);
		}
		if (isRightward) {
			return new Point(Direction.RIGHT);
		}
		return new Point(Direction.STRAIGHT);
	}

	public static Point last(Point previous) {
		if (previous.direction.isRight()) {
			return new Point(Direction.LEFT);
		}
		return new Point(Direction.STRAIGHT);
	}

	public boolean isRightward() {
		return direction.isRight();
	}

	public boolean isLeftward() {
		return direction.isLeft();
	}

	public boolean isDownward() {
		return direction.isStraight();
	}

	public Direction direction() {
		return direction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return direction == point.direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction);
	}
}

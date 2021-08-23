package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.util.RandomDirectionFactory;

public class Point {

	private final Direction direction;

	public Point(Direction direction) {
		this.direction = direction;
	}

	public static Point first() {
		if (RandomDirectionFactory.isRight()) {
			return new Point(Direction.RIGHT);
		}
		return new Point(Direction.STRAIGHT);
	}

	public static Point next(Point previous) {
		if (previous.direction.isRight()) {
			return new Point(Direction.LEFT);
		}
		if (RandomDirectionFactory.isRight()) {
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

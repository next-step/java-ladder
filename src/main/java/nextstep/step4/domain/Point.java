package nextstep.step4.domain;

import java.util.Objects;

public class Point {

	private final int index;
	private final Direction direction;

	public Point(int index, Direction direction) {
		this.index = index;
		this.direction = direction;
	}

	public static Point first(boolean isRight) {
		return new Point(0, Direction.first(isRight));
	}

	public Point next(boolean isRight) {
		return new Point(index + 1, direction.next(isRight));
	}

	public Point last() {
		return new Point(index + 1, direction.last());
	}

	public int move() {
		if (direction.isRight()) {
			return index + 1;
		}
		if (direction.isLeft()) {
			return index - 1;
		}
		return index;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point)o;
		return index == point.index && Objects.equals(direction, point.direction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, direction);
	}
}

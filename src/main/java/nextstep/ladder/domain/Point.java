package nextstep.ladder.domain;

import static nextstep.ladder.domain.Direction.*;

import java.util.Objects;

public class Point {

	private final int position;
	private final Direction direction;

	private Point(int position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public static Point of(int position, Direction direction) {
		return new Point(position, direction);
	}

	public static Point right(int position) {
		return new Point(position, RIGHT);
	}

	public static Point left(int position) {
		return new Point(position, LEFT);
	}

	public static Point straight(int position) {
		return new Point(position, STRAIGHT);
	}

	public static Point first(boolean isRightward) {
		if (isRightward) {
			return new Point(0, RIGHT);
		}
		return new Point(0, STRAIGHT);
	}

	public static Point next(Point previous, boolean isRightward) {
		if (previous.direction.isRight()) {
			return new Point(previous.position + 1, LEFT);
		}
		if (isRightward) {
			return new Point(previous.position + 1, RIGHT);
		}
		return new Point(previous.position + 1, STRAIGHT);
	}

	public static Point last(Point previous) {
		if (previous.direction.isRight()) {
			return new Point(previous.position + 1, LEFT);
		}
		return new Point(previous.position + 1, STRAIGHT);
	}

	public int move() {
		return position + direction.value();
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

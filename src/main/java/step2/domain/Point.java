package step2.domain;

import java.util.Objects;
import java.util.function.IntSupplier;

import step2.util.Validator;

public class Point {

	private static final int FIRST_POINT_THRESHOLD = 5;

	private final Direction direction;

	private Point(Direction direction) {
		this.direction = direction;
	}

	public static Point firstPointFrom(IntSupplier supplier) {
		Validator.notNull(supplier);
		if (supplier.getAsInt() < FIRST_POINT_THRESHOLD) {
			return new Point(Direction.STRAIGHT);
		}
		return new Point(Direction.RIGHT);
	}

	public static Point firstPointFrom(Direction direction) {
		Validator.notNull(direction);
		if (direction == Direction.LEFT) {
			throw new IllegalArgumentException("첫 번째 포인트는 왼쪽일 수 없습니다.");
		}
		return new Point(direction);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point that = (Point)o;
		return direction == that.direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction);
	}
}

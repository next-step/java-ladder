package nextstep.step4.domain;

import java.util.Objects;

public class Direction {

	private final boolean left;
	private final boolean right;

	private Direction(boolean left, boolean right) {
		validateDirection(left, right);
		this.left = left;
		this.right = right;
	}

	public static Direction first(boolean isRight) {
		return new Direction(false, isRight);
	}

	public static Direction of(boolean left, boolean right) {
		return new Direction(left, right);
	}

	public Direction next(boolean isRight) {
		return Direction.of(this.right, isRight);
	}

	public Direction last() {
		return new Direction(right, false);
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	private void validateDirection(boolean left, boolean right) {
		if (left && right) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Direction direction = (Direction)o;
		return left == direction.left && right == direction.right;
	}

	@Override
	public int hashCode() {
		return Objects.hash(left, right);
	}
}

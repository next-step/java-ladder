package laddergame2.domain;

import static java.lang.Boolean.FALSE;

import java.util.Objects;

public class Direction {

	private final Boolean left;
	private final Boolean right;

	private Direction(Boolean left, Boolean right) {
		if (left && right) {
			throw new IllegalStateException("모든 방향으로 선을 가질 수 없습니다.");
		}

		this.left = left;
		this.right = right;
	}

	public static Direction first(Boolean right) {
		return of(FALSE, right);
	}

	public static Direction of(Boolean left, Boolean right) {
		return new Direction(left, right);
	}

	public Direction next() {
		if (right) {
			return next(FALSE);
		}
		return next(RandomGenerator.generate());
	}

	public Direction next(Boolean nextRight) {
		return Direction.of(right, nextRight);
	}

	public Direction last() {
		return of(right, FALSE);
	}

	public Boolean isLeft() {
		return left;
	}

	public Boolean isRight() {
		return right;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Direction)) {
			return false;
		}
		Direction direction = (Direction) o;
		return Objects.equals(left, direction.left) &&
				Objects.equals(right, direction.right);
	}

	@Override
	public int hashCode() {
		return Objects.hash(left, right);
	}

	@Override
	public String toString() {
		return "Direction{" +
				"left=" + left +
				", right=" + right +
				'}';
	}
}

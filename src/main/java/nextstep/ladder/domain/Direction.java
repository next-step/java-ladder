package nextstep.ladder.domain;

import java.util.Objects;

public class Direction {
	private static final String INVALID_MESSAGE = "left, right 두개 모두 존재할수 없습니다.";

	private final boolean left;
	private final boolean right;

	private Direction(boolean left, boolean right) {
		validate(left, right);
		this.left = left;
		this.right = right;
	}

	private void validate(boolean hasLeft, boolean hasRight) {
		if (hasLeft && hasRight) {
			throw new IllegalArgumentException(INVALID_MESSAGE);
		}
	}

	public static Direction create(boolean left, boolean right) {
		return new Direction(left, right);
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Direction direction = (Direction)obj;

		if (left != direction.left) {
			return false;
		}
		return right == direction.right;
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

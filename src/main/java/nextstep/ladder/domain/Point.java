package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
	private static final String INVALID_MESSAGE = "left, right 두개 모두 존재할수 없습니다.";

	private final boolean hasLeft;
	private final boolean hasRight;

	private Point(boolean hasLeft, boolean hasRight) {
		validate(hasLeft, hasRight);
		this.hasLeft = hasLeft;
		this.hasRight = hasRight;
	}

	private void validate(boolean hasLeft, boolean hasRight) {
		if (hasLeft && hasRight) {
			throw new IllegalArgumentException(INVALID_MESSAGE);
		}
	}

	public static Point create(boolean hasLeft, boolean hasRight) {
		return new Point(hasLeft, hasRight);
	}

	public static Point createFirstOfLine(boolean hasRight) {
		return create(false, hasRight);
	}

	public static Point createLastOfLine(boolean hasBeforeRight) {
		return create(hasBeforeRight, false);
	}

	public boolean hasLeft() {
		return this.hasLeft;
	}

	public boolean hasRight() {
		return this.hasRight;
	}

	public int move(int index) {
		if (hasLeft()) {
			index--;
		}
		if (hasRight()) {
			index++;
		}
		return index;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Point point = (Point)obj;

		if (hasLeft != point.hasLeft) {
			return false;
		}
		return hasRight == point.hasRight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hasLeft, hasRight);
	}
}
